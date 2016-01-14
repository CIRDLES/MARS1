package org.cirdles.mars.scripps;

import org.cirdles.commons.util.ResourceExtractor;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by johnzeringue on 12/27/15.
 */
public class CsvScrippsSampleSourceTest {

    private static final ResourceExtractor RESOURCE_EXTRACTOR
            = new ResourceExtractor(CsvScrippsSampleSourceTest.class);

    private ScrippsSampleSource source;

    @Before
    public void setUp() {
        Path coreSampleCsv = RESOURCE_EXTRACTOR
                .extractResourceAsPath("SHOW-H Core Sample.csv");

        Path coreIntervalCsv = RESOURCE_EXTRACTOR
                .extractResourceAsPath("SHOW-H Core Interval.csv");

        source = new CsvScrippsSampleSource(coreSampleCsv, coreIntervalCsv);
    }

    @Test
    public void testGetSamples() throws Exception {
        assertThat(source.getScrippsSamples()).hasSize(21);
    }

}