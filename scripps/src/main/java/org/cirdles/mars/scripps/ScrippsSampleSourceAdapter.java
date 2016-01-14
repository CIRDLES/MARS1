package org.cirdles.mars.scripps;

import org.cirdles.mars.api.SampleSource;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by johnzeringue on 1/9/16.
 */
public class ScrippsSampleSourceAdapter implements SampleSource {

    private final ScrippsSampleSource scrippsSampleSource;

    public ScrippsSampleSourceAdapter(ScrippsSampleSource scrippsSampleSource) {
        this.scrippsSampleSource = scrippsSampleSource;
    }

    @Override
    public List<ScrippsSampleAdapter> getSamples() {
        return scrippsSampleSource
                .getScrippsSamples()
                .stream()
                .map(ScrippsSampleAdapter::new)
                .collect(toList());
    }

}
