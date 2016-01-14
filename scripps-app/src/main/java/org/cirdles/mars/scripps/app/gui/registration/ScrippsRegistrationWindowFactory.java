package org.cirdles.mars.scripps.app.gui.registration;

import javafx.scene.control.Dialog;
import javafx.util.BuilderFactory;
import org.cirdles.mars.api.SampleRegistryClient;
import org.cirdles.mars.api.SampleSource;

import javax.inject.Inject;

/**
 * Created by johnzeringue on 1/8/16.
 */
public class ScrippsRegistrationWindowFactory {

    private final BuilderFactory builderFactory;
    private final Dialog<SampleRegistryClient> sampleRegistryClientDialog;

    @Inject
    public ScrippsRegistrationWindowFactory(
            BuilderFactory builderFactory,
            Dialog<SampleRegistryClient> sampleRegistryClientDialog) {

        this.builderFactory = builderFactory;
        this.sampleRegistryClientDialog = sampleRegistryClientDialog;
    }

    public ScrippsRegistrationWindow createScrippsRegistrationWindow(
            SampleSource sampleSource) {

        return new ScrippsRegistrationWindow(
                builderFactory,
                sampleRegistryClientDialog,
                sampleSource);
    }

}
