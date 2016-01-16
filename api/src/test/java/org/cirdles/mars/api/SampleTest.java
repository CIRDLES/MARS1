package org.cirdles.mars.api;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by johnzeringue on 1/16/16.
 */
public class SampleTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private Sample sample;

    @Before
    public void setUp() throws Exception {
        sample = new Sample() {

            @Override
            public String getArchive() {
                return null;
            }

            @Override
            public String getPlatformName() {
                return null;
            }

            @Override
            public String getCruiseName() {
                return null;
            }

            @Override
            public String getName() {
                return null;
            }

            @Override
            public String getCollectionMethod() {
                return null;
            }

            @Override
            public LocalDate getCollectionBeginDate() {
                return null;
            }

            @Override
            public LocalDate getCollectionEndDate() {
                return null;
            }

            @Override
            public BigDecimal getWgs84Latitude() {
                return null;
            }

            @Override
            public BigDecimal getWgs84EndingLatitude() {
                return null;
            }

            @Override
            public BigDecimal getWgs84Longitude() {
                return null;
            }

            @Override
            public BigDecimal getWgs84EndingLongitude() {
                return null;
            }

            @Override
            public BigDecimal getElevation() {
                return null;
            }

            @Override
            public BigDecimal getEndingElevation() {
                return null;
            }

            @Override
            public String getMaterial() {
                return null;
            }

            @Override
            public String getType() {
                return null;
            }

        };
    }

    @Test
    public void testSetArchive() throws Exception {
        exception.expect(UnsupportedOperationException.class);
        sample.setArchive(null);
    }

    @Test
    public void testSetPlatformName() throws Exception {
        exception.expect(UnsupportedOperationException.class);
        sample.setPlatformName(null);
    }

    @Test
    public void testSetCruiseName() throws Exception {
        exception.expect(UnsupportedOperationException.class);
        sample.setCruiseName(null);
    }

    @Test
    public void testSetName() throws Exception {
        exception.expect(UnsupportedOperationException.class);
        sample.setName(null);
    }

    @Test
    public void testSetCollectionMethod() throws Exception {
        exception.expect(UnsupportedOperationException.class);
        sample.setCollectionMethod(null);
    }

    @Test
    public void testSetCollectionBeginDate() throws Exception {
        exception.expect(UnsupportedOperationException.class);
        sample.setCollectionBeginDate(null);
    }

    @Test
    public void testSetCollectionEndDate() throws Exception {
        exception.expect(UnsupportedOperationException.class);
        sample.setCollectionEndDate(null);
    }

    @Test
    public void testSetWgs84Latitude() throws Exception {
        exception.expect(UnsupportedOperationException.class);
        sample.setWgs84Latitude(null);
    }

    @Test
    public void testSetWgs84EndingLatitude() throws Exception {
        exception.expect(UnsupportedOperationException.class);
        sample.setWgs84EndingLatitude(null);
    }

    @Test
    public void testSetWgs84Longitude() throws Exception {
        exception.expect(UnsupportedOperationException.class);
        sample.setWgs84Longitude(null);
    }

    @Test
    public void testSetWgs84EndingLongitude() throws Exception {
        exception.expect(UnsupportedOperationException.class);
        sample.setWgs84EndingLongitude(null);
    }

    @Test
    public void testSetElevation() throws Exception {
        exception.expect(UnsupportedOperationException.class);
        sample.setElevation(null);
    }

    @Test
    public void testSetEndingElevation() throws Exception {
        exception.expect(UnsupportedOperationException.class);
        sample.setEndingElevation(null);
    }

    @Test
    public void testSetMaterial() throws Exception {
        exception.expect(UnsupportedOperationException.class);
        sample.setMaterial(null);
    }

    @Test
    public void testSetType() throws Exception {
        exception.expect(UnsupportedOperationException.class);
        sample.setType(null);
    }

    @Test
    public void testIsMutable() throws Exception {
        assertThat(sample.isMutable()).isFalse();
    }

}