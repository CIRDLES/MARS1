package org.cirdles.mars.scripps.app.gui.sesar;

import dagger.Module;
import dagger.Provides;
import javafx.scene.control.Dialog;
import org.cirdles.mars.api.SampleRegistryClient;

/**
 * Created by johnzeringue on 1/9/16.
 */
@Module
public class SesarModule {

    @Provides
    public Dialog<SampleRegistryClient> provideSampleRegistryClientDialog(
            SesarLoginDialog sesarLoginDialog) {

        return sesarLoginDialog;
    }

}
