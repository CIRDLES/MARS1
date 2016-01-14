package org.cirdles.mars.cesar;

import org.cirdles.mars.api.Sample;
import org.cirdles.mars.cesar.jaxb.Samples;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import java.time.LocalDate;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by johnzeringue on 12/21/15.
 */
public class SesarTranslatorTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Mock
    private Sample sample;

    private SesarTranslator mapper;

    @Before
    public void setUp() {
        mapper = new SesarTranslator("JJZ");
    }

    @Test
    public void testTranslateToSesarSamples() throws Exception {
        when(sample.getCollectionBeginDate())
                .thenReturn(LocalDate.of(2000, 01, 01));

        Samples actual = mapper.translateToSesarSamples(() -> asList(sample));
        Samples.Sample actualSample = actual.getSample().get(0);

        Samples.Sample expectedSample = new Samples.Sample();
        expectedSample.setUserCode("JJZ");

        expectedSample.setCollectionStartDate(DatatypeFactory.newInstance()
                .newXMLGregorianCalendarDate(
                        2000, 01, 01,
                        DatatypeConstants.FIELD_UNDEFINED));

        assertThat(actual.getSample()).hasSize(1);
        assertThat(actualSample).isEqualToComparingFieldByField(expectedSample);
    }

}