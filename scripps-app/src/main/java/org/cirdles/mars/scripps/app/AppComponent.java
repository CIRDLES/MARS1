package org.cirdles.mars.scripps.app;

import dagger.Component;
import org.cirdles.mars.scripps.app.builder.BuilderModule;
import org.cirdles.mars.scripps.app.gui.in.ScrippsImportWindow;
import org.cirdles.mars.scripps.app.gui.sesar.SesarModule;

/**
 * Created by johnzeringue on 12/30/15.
 */
@Component(modules = {
        BuilderModule.class,
        SesarModule.class
})
public interface AppComponent {

    ScrippsImportWindow scrippsImportWindow();

}
