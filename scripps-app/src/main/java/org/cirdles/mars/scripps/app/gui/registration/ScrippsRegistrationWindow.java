package org.cirdles.mars.scripps.app.gui.registration;

import com.johnzeringue.extendsfx.layout.CustomVBox;
import javafx.fxml.FXML;
import javafx.scene.control.Dialog;
import javafx.util.BuilderFactory;
import org.cirdles.mars.api.SampleRegistryClient;
import org.cirdles.mars.api.SampleSource;

/**
 * Created by johnzeringue on 1/8/16.
 */
public class ScrippsRegistrationWindow extends CustomVBox<ScrippsRegistrationWindow> {

    private BuilderFactory builderFactory;
    private Dialog<SampleRegistryClient> sampleRegistryClientDialog;
    private SampleSource sampleSource;

    public ScrippsRegistrationWindow(
            BuilderFactory builderFactory,
            Dialog<SampleRegistryClient> sampleRegistryClientDialog,
            SampleSource sampleSource) {

        super(self -> {
            self.builderFactory = builderFactory;
            self.sampleRegistryClientDialog = sampleRegistryClientDialog;
            self.sampleSource = sampleSource;
        });
    }

    private void registerSampleSource(
            SampleRegistryClient sampleRegistryClient) {

        sampleRegistryClient.register(sampleSource);
    }

    @FXML
    private void registerSamples() {
        sampleRegistryClientDialog
                .showAndWait()
                .ifPresent(this::registerSampleSource);
    }

    @Override
    public BuilderFactory getBuilderFactory() {
        return builderFactory;
    }

}
