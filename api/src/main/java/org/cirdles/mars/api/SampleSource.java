package org.cirdles.mars.api;

import java.util.List;

/**
 * Created by johnzeringue on 12/10/15.
 */
public interface SampleSource {

    List<? extends Sample> getSamples();

}
