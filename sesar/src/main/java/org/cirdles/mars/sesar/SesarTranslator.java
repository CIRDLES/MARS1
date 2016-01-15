package org.cirdles.mars.sesar;

import org.cirdles.mars.api.Sample;
import org.cirdles.mars.api.SampleSource;
import org.cirdles.mars.sesar.jaxb.ObjectFactory;
import org.cirdles.mars.sesar.jaxb.Samples;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;

/**
 * Created by johnzeringue on 12/10/15.
 */
public class SesarTranslator {

    private static final DatatypeFactory DATATYPE_FACTORY;

    static {
        try {
            DATATYPE_FACTORY = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException ex) {
            throw new RuntimeException(ex);
        }
    }

    private final ObjectFactory factory;

    private final String userCode;

    public SesarTranslator(String userCode) {
        this.userCode = userCode;
        factory = new ObjectFactory();
    }

    private static XMLGregorianCalendar asXmlGregorianCalendar(LocalDate localDate) {
        XMLGregorianCalendar result = null;

        if (localDate != null) {
            result = DATATYPE_FACTORY.newXMLGregorianCalendarDate(
                    localDate.getYear(),
                    localDate.getMonthValue(),
                    localDate.getDayOfMonth(),
                    DatatypeConstants.FIELD_UNDEFINED);
        }

        return result;
    }

    private Samples.Sample translateToSesarSample(Sample sample) {
        Samples.Sample mappedSamplesSample = factory.createSamplesSample();

        mappedSamplesSample.setUserCode(userCode);
        mappedSamplesSample.setSampleType(sample.getType());
        mappedSamplesSample.setName(sample.getName());
        mappedSamplesSample.setMaterial(sample.getMaterial());

        mappedSamplesSample.setLatitude(sample.getWgs84Latitude());
        mappedSamplesSample.setLongitude(sample.getWgs84Longitude());
        mappedSamplesSample.setLatitudeEnd(sample.getWgs84EndingLatitude());
        mappedSamplesSample.setLongitudeEnd(sample.getWgs84EndingLongitude());
        mappedSamplesSample.setElevation(sample.getElevation());
        mappedSamplesSample.setElevationEnd(sample.getEndingElevation());

        mappedSamplesSample.setCruiseFieldPrgrm(sample.getCruiseName());
        mappedSamplesSample.setPlatformName(sample.getPlatformName());

        mappedSamplesSample.setCollectionStartDate(
                asXmlGregorianCalendar(sample.getCollectionBeginDate()));

        mappedSamplesSample.setCollectionEndDate(
                asXmlGregorianCalendar(sample.getCollectionEndDate()));

        return mappedSamplesSample;
    }

    public Samples translateToSesarSamples(SampleSource sampleSource) {
        Samples mappedSamples = factory.createSamples();

        sampleSource.getSamples()
                .stream()
                .map(this::translateToSesarSample)
                .forEach(mappedSamples.getSample()::add);

        return mappedSamples;
    }

}
