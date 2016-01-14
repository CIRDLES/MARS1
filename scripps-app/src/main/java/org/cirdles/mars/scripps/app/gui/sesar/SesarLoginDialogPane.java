package org.cirdles.mars.scripps.app.gui.sesar;

import javafx.scene.control.DialogPane;

import javax.inject.Inject;

import static javafx.scene.control.ButtonType.CLOSE;
import static javafx.scene.control.ButtonType.OK;

/**
 * Created by johnzeringue on 1/10/16.
 */
public class SesarLoginDialogPane extends DialogPane {

    private final SesarLoginDialogView sesarLoginDialogView;

    @Inject
    public SesarLoginDialogPane(SesarLoginDialogView sesarLoginDialogView) {
        getButtonTypes().setAll(OK, CLOSE);
        this.sesarLoginDialogView = sesarLoginDialogView;
        setContent(sesarLoginDialogView);
    }

    public String getUsername() {
        return sesarLoginDialogView.getUsername();
    }

    public String getPassword() {
        return sesarLoginDialogView.getPassword();
    }

    public String getUserCode() {
        return sesarLoginDialogView.getUserCode();
    }

}
