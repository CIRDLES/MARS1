package org.cirdles.mars.sesar;

import org.cirdles.mars.api.SampleRegistryClient;
import org.cirdles.mars.api.SampleSource;
import org.cirdles.mars.sesar.jaxb.Samples;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

import static javax.ws.rs.client.Entity.form;
import static org.glassfish.jersey.client.ClientProperties.CONNECT_TIMEOUT;
import static org.glassfish.jersey.client.ClientProperties.READ_TIMEOUT;

/**
 * Created by johnzeringue on 12/10/15.
 */
public class SesarClient implements SampleRegistryClient {

    private static final String DEFAULT_BASE_URI
            = "http://app.geosamples.org/webservices";

    public static final String UTF_8 = "UTF-8";
    public static final String CREDENTIALS_PATH = "/credentials_service.php";
    public static final String UPLOAD_PATH = "/upload.php";

    private final WebTarget baseTarget;

    private final String username;
    private final String password;
    private final SesarTranslator sampleMapper;

    public SesarClient(String username, String password, String userCode) {
        this(
                username,
                password,
                DEFAULT_BASE_URI,
                new SesarTranslator(userCode));
    }

    public SesarClient(
            String username,
            String password,
            String baseUri,
            SesarTranslator sampleMapper) {
        this.username = username;
        this.password = password;
        this.sampleMapper = sampleMapper;

        baseTarget = ClientBuilder
                .newClient()
                .property(CONNECT_TIMEOUT, 5000)
                .property(READ_TIMEOUT, 5000)
                .target(baseUri);
    }

    @Override
    public boolean checkAuthentication() {
        String response = baseTarget.path(CREDENTIALS_PATH)
                .request(
                        MediaType.APPLICATION_XML_TYPE,
                        MediaType.TEXT_XML_TYPE)
                .post(Entity.text(""
                        + "username=" + username + "\n"
                        + "password=" + password))
                .readEntity(String.class);

        return response.contains("<valid>yes</valid>");
    }

    @Override
    public void register(SampleSource sampleSource) {
        Samples samples = sampleMapper.translateToSesarSamples(sampleSource);

        String samplesXml;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Samples.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            marshaller.marshal(samples, outputStream);
            samplesXml = outputStream.toString(UTF_8);
        } catch (JAXBException | UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }

        Form uploadForm = new Form();
        uploadForm.param("username", username);
        uploadForm.param("password", password);
        uploadForm.param("content", samplesXml);

        Response response = baseTarget.path(UPLOAD_PATH)
                .request(
                        MediaType.APPLICATION_XML_TYPE,
                        MediaType.TEXT_XML_TYPE)
                .post(form(uploadForm));

        if (response.getStatus() != 200) {
            throw new SesarException(response.readEntity(String.class));
        } else {
            System.out.println("Success!");
            System.out.println(response.readEntity(String.class));
        }
    }

}
