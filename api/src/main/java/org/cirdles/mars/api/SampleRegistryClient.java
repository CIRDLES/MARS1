package org.cirdles.mars.api;

import java.util.List;

/**
 * An interface defining a client for a sample registry.
 */
public interface SampleRegistryClient {

    /**
     * Checks this client's authentication unless the registry does not require
     * authentication.
     *
     * @return whether or not this client is authenticated
     */
    boolean checkAuthentication();

    /**
     * Registers the samples from the given source in this client's registry.
     * It returns a list of registration strings whose length should match the
     * length of the list of samples provided by the sample source. If this
     * registry does not assign registration strings, it should return null.
     *
     * @param sampleSource the source of the samples
     * @return a list of registration strings or null if not provided
     */
    List<String> register(SampleSource sampleSource);

}
