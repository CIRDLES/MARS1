package org.cirdles.mars.scripps.app.gui.sesar;

import javafx.scene.control.Dialog;
import org.cirdles.mars.api.SampleRegistryClient;
import org.cirdles.mars.cesar.SesarClient;

import javax.inject.Inject;

/**
 * Created by johnzeringue on 1/9/16.
 */
public class SesarLoginDialog extends Dialog<SampleRegistryClient> {

    private final SesarLoginDialogPane sesarLoginDialogPane;

    @Inject
    public SesarLoginDialog(SesarLoginDialogPane sesarLoginDialogPane) {
        this.sesarLoginDialogPane = sesarLoginDialogPane;
        setDialogPane(sesarLoginDialogPane);

        setResultConverter(buttonType -> {
            return new SesarClient(
                    sesarLoginDialogPane.getUsername(),
                    sesarLoginDialogPane.getPassword(),
                    sesarLoginDialogPane.getUserCode());
        });
    }

}
