package org.cirdles.mars.scripps.app.gui.sesar;

import com.johnzeringue.extendsfx.layout.CustomGridPane;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.inject.Inject;

/**
 * Created by johnzeringue on 1/10/16.
 */
public class SesarLoginDialogView extends CustomGridPane<SesarLoginDialogView> {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField userCodeField;

    @Inject
    public SesarLoginDialogView() {
        super();
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }

    public String getUserCode() {
        return userCodeField.getText();
    }

}
