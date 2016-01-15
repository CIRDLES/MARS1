package org.cirdles.mars.sesar;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.cirdles.mars.api.SampleRegistryClient;
import org.cirdles.mars.api.SampleSource;
import org.cirdles.mars.sesar.jaxb.Samples;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by johnzeringue on 12/11/15.
 */
public class SesarClientTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public WireMockRule wireMockRule = new WireMockRule();

    @Mock
    private SesarTranslator sampleMapper;

    @Mock
    private SampleSource sampleSource;

    private SampleRegistryClient client;

    @Before
    public void setUp() {
        client = new SesarClient(
                "username",
                "password",
                "http://localhost:8080",
                sampleMapper);
    }

    @Test
    public void testCheckAuthenticationValid() {
        stubFor(post(urlEqualTo("/credentials_service.php"))
                .withHeader("Accept", containing("text/xml"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody(""
                                + "<results>\n"
                                + "    <valid>yes</valid>\n"
                                + "    <user_codes>\n"
                                + "        <user_code>MOB</user_code>\n"
                                + "    </user_codes>\n"
                                + "</results> ")));

        assertThat(client.checkAuthentication()).isTrue();
    }

    @Test
    public void testCheckAuthenticationInvalid() {
        stubFor(post(urlEqualTo("/credentials_service.php"))
                .withHeader("Accept", containing("text/xml"))
                .willReturn(aResponse()
                        .withStatus(401)
                        .withHeader("Content-Type", "text/xml")
                        .withBody(""
                                + "<results>\n"
                                + "    <valid>no</valid>\n"
                                + "    <error>Invalid login, username not known or password not matched</error>\n"
                                + "</results>")));

        assertThat(client.checkAuthentication()).isFalse();
    }

    @Test
    public void testRegister() throws Exception {
        Samples samples = new Samples();
        Samples.Sample samplesSample = new Samples.Sample();
        samplesSample.setUserCode("JJZ");
        samplesSample.setName("Test");
        samples.getSample().add(samplesSample);

        when(sampleMapper.translateToSesarSamples(sampleSource)).thenReturn(samples);

        stubFor(post(urlEqualTo("/upload.php"))
                .withHeader("Accept", containing("text/xml"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("<response>Some content</response>")));

        client.register(sampleSource);

        verify(postRequestedFor(urlMatching("/upload.php"))
                .withRequestBody(containing("username=username"))
                .withRequestBody(containing("password=password"))
                .withRequestBody(containing("content=%3C%3Fxml+version%3D%221.0%22"))
                .withRequestBody(containing("%3Cname%3ETest%3C%2Fname%3E"))
                .withRequestBody(containing("%3Cuser_code%3EJJZ%3C%2Fuser_code%3E")));
    }

}