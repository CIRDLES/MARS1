package org.cirdles.mars.scripps.app.gui.verification;

import com.johnzeringue.extendsfx.layout.CustomVBox;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.BuilderFactory;
import org.cirdles.mars.scripps.ScrippsSampleSource;
import org.cirdles.mars.scripps.ScrippsSampleSourceAdapter;
import org.cirdles.mars.scripps.app.gui.registration.ScrippsRegistrationWindowFactory;

/**
 * Created by johnzeringue on 1/4/16.
 */
public class ScrippsVerificationWindow extends CustomVBox<ScrippsVerificationWindow> {

    private BuilderFactory builderFactory;
    private ScrippsRegistrationWindowFactory registrationWindowFactory;
    private ScrippsSampleSource scrippsSampleSource;

    public ScrippsVerificationWindow(
            BuilderFactory builderFactory,
            ScrippsRegistrationWindowFactory registrationWindowFactory,
            ScrippsSampleSource scrippsSampleSource) {

        super(self -> {
            self.builderFactory = builderFactory;
            self.registrationWindowFactory = registrationWindowFactory;
            self.scrippsSampleSource = scrippsSampleSource;
        });
    }

    @FXML
    private void initialize() {
        // TODO
    }

    @FXML
    private void verifyAndContinue() {
        ScrippsSampleSourceAdapter sampleSource
                = new ScrippsSampleSourceAdapter(scrippsSampleSource);

        Parent verificationWindow = registrationWindowFactory
                .createScrippsRegistrationWindow(sampleSource);

        Stage stage = new Stage();
        stage.setScene(new Scene(verificationWindow));
        stage.show();

        ((Stage) getScene().getWindow()).close();
    }

    @Override
    public BuilderFactory getBuilderFactory() {
        return builderFactory;
    }

}
