package org.cirdles.mars.scripps.app;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by johnzeringue on 12/29/15.
 */
public class ScrippsApplication extends Application {

    public ScrippsApplication() {
        super();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AppComponent appComponent = DaggerAppComponent.create();
        Parent parent = appComponent.scrippsImportWindow();

        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
