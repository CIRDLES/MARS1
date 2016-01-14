package org.cirdles.mars.scripps.app.gui.common;

import com.johnzeringue.extendsfx.layout.CustomHBox;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.File;
import java.nio.file.Path;
import java.util.function.Supplier;

/**
 * Created by johnzeringue on 1/3/16.
 */
public class CsvFileChooserButton extends CustomHBox<CsvFileChooserButton> {

    @FXML
    private Text fileNameText;

    private final ObjectProperty<Path> pathProperty = new ObjectPropertyBase<Path>() {

        @Override
        public Object getBean() {
            return CsvFileChooserButton.this;
        }

        @Override
        public String getName() {
            return "path";
        }

    };

    private final Supplier<File> fileChooser;

    public CsvFileChooserButton() {
        this(() -> csvFileChooser().showOpenDialog(null));
    }

    public CsvFileChooserButton(Supplier<File> fileChooser) {
        this.fileChooser = fileChooser;

        pathProperty.addListener((observable, oldValue, newValue) -> {
            fileNameText.setText(getPath().getFileName().toString());
        });
    }

    private static FileChooser csvFileChooser() {
        FileChooser csvFileChooser = new FileChooser();

        ExtensionFilter csvExtensionFilter = new ExtensionFilter(
                "Comma Separated (.csv)",
                "*.csv");

        csvFileChooser.getExtensionFilters().add(csvExtensionFilter);
        return csvFileChooser;
    }

    public Path getPath() {
        return pathProperty.get();
    }

    public void setPath(Path path) {
        pathProperty.set(path);
    }

    public ObjectProperty<Path> pathProperty() {
        return pathProperty;
    }

    @FXML
    private void showFileChooser() {
        File chosenFile = fileChooser.get();

        if (chosenFile != null) {
            setPath(chosenFile.toPath());
        }
    }

}
