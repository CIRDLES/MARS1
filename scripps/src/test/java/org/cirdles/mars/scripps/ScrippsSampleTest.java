package org.cirdles.mars.scripps;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by johnzeringue on 12/27/15.
 */
public class ScrippsSampleTest {

    private ScrippsSample scrippsSample;

    @Before
    public void setUp() {
        scrippsSample = new ScrippsSample();
    }

    @Test
    public void testFacilityCode() {
        String facilityCode = scrippsSample
                .setFacilityCode("ABC")
                .getFacilityCode();

        assertThat(facilityCode).isEqualTo("ABC");
    }

    @Test
    public void testShipCode() {
        String shipCode = scrippsSample
                .setShipCode("123")
                .getShipCode();

        assertThat(shipCode).isEqualTo("123");
    }

    @Test
    public void testPlatform() {
        String platform = scrippsSample
                .setPlatform("Falcon")
                .getPlatform();

        assertThat(platform).isEqualTo("Falcon");
    }

    @Test
    public void testCruise() {
        String cruise = scrippsSample
                .setCruise("CIRDLES")
                .getCruise();

        assertThat(cruise).isEqualTo("CIRDLES");
    }

    @Test
    public void testSample() {
        String sample = scrippsSample
                .setSample("CIRDLES-001")
                .getSample();

        assertThat(sample).isEqualTo("CIRDLES-001");
    }

    @Test
    public void testDevice() {
        String device = scrippsSample
                .setDevice("core, gravity")
                .getDevice();

        assertThat(device).isEqualTo("core, gravity");
    }

    @Test
    public void testBeginDate() {
        String beginDate = scrippsSample
                .setBeginDate("20000101")
                .getBeginDate();

        assertThat(beginDate).isEqualTo("20000101");
    }

    @Test
    public void testEndDate() {
        String endDate = scrippsSample
                .setEndDate("20000101")
                .getEndDate();

        assertThat(endDate).isEqualTo("20000101");
    }

    @Test
    public void testLat() {
        BigDecimal lat = scrippsSample
                .setLat(new BigDecimal("32.7833"))
                .getLat();

        assertThat(lat).isEqualTo("32.7833");
    }

    @Test
    public void testEndLatmin() {
        BigDecimal endLatmin = scrippsSample
                .setEndLatmin(new BigDecimal("32.7833"))
                .getEndLatmin();

        assertThat(endLatmin).isEqualTo("32.7833");
    }

    @Test
    public void testLon() {
        BigDecimal lon = scrippsSample
                .setLon(new BigDecimal("-79.9333"))
                .getLon();

        assertThat(lon).isEqualTo("-79.9333");
    }

    @Test
    public void testEndLon() {
        BigDecimal endLon = scrippsSample
                .setEndLon(new BigDecimal("-79.9333"))
                .getEndLon();

        assertThat(endLon).isEqualTo("-79.9333");
    }

    @Test
    public void testWaterDepth() {
        BigDecimal waterDepth = scrippsSample
                .setWaterDepth(new BigDecimal("10"))
                .getWaterDepth();

        assertThat(waterDepth).isEqualTo("10");
    }

    @Test
    public void testEndWaterDepth() {
        BigDecimal endWaterDepth = scrippsSample
                .setEndWaterDepth(new BigDecimal("10"))
                .getEndWaterDepth();

        assertThat(endWaterDepth).isEqualTo("10");
    }

}
