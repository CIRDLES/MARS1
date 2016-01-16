package org.cirdles.mars.scripps;

import org.cirdles.mars.api.Sample;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by johnzeringue on 1/16/16.
 */
public class ScrippsSampleAdapterTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private ScrippsSample scrippsSample;

    private Sample sample;

    @Before
    public void setUp() {
        sample = new ScrippsSampleAdapter(scrippsSample);
    }

    @Test
    public void testIsMutable() throws Exception {
        assertThat(sample.isMutable()).isTrue();
    }

}