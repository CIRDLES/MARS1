package org.cirdles.mars.scripps.app.gui.in;

import com.johnzeringue.extendsfx.layout.CustomVBox;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.BuilderFactory;
import org.cirdles.mars.scripps.CsvScrippsSampleSource;
import org.cirdles.mars.scripps.ScrippsSampleSource;
import org.cirdles.mars.scripps.app.gui.common.CsvFileChooserButton;
import org.cirdles.mars.scripps.app.gui.verification.ScrippsVerificationWindowFactory;

import javax.inject.Inject;

/**
 * Created by johnzeringue on 12/29/15.
 */
public class ScrippsImportWindow extends CustomVBox<ScrippsImportWindow> {

    @FXML
    private CsvFileChooserButton coreSamplesCsv;

    @FXML
    private CsvFileChooserButton coreIntervalsCsv;

    @FXML
    private Text selectSamplesText;

    @FXML
    private Text selectIntervalsText;

    @FXML
    private Button continueButton;

    private BuilderFactory builderFactory;
    private ScrippsVerificationWindowFactory verificationWindowFactory;

    @Inject
    public ScrippsImportWindow(
            BuilderFactory builderFactory,
            ScrippsVerificationWindowFactory verificationWindowFactory) {

        super(self -> {
            self.builderFactory = builderFactory;
            self.verificationWindowFactory = verificationWindowFactory;
        });
    }

    @FXML
    private void initialize() {
        // continue button disabled until samples CSV and intervals CSV
        // provided
        continueButton.disableProperty().bind(
                coreSamplesCsv.pathProperty().isNull()
                        .or(coreIntervalsCsv.pathProperty().isNull()));

        // show select samples text when samples CSV is not provided
        selectSamplesText.visibleProperty().bind(
                coreSamplesCsv.pathProperty().isNull());

        // show select intervals text when samples CSV is provided but intervals
        // CSV is not
        selectIntervalsText.visibleProperty().bind(
                coreSamplesCsv.pathProperty().isNotNull()
                        .and(coreIntervalsCsv.pathProperty().isNull()));
    }

    @FXML
    private void continueToVerification() {
        ScrippsSampleSource sampleSource = new CsvScrippsSampleSource(
                coreSamplesCsv.getPath(),
                coreIntervalsCsv.getPath());

        Parent verificationWindow = verificationWindowFactory
                .createScrippsVerificationWindow(sampleSource);

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
