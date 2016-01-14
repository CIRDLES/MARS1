package org.cirdles.mars.api;

/**
 * Created by johnzeringue on 12/10/15.
 */
public interface SampleRegistryClient {

    boolean checkAuthentication();

    void register(SampleSource sampleSource);

}
