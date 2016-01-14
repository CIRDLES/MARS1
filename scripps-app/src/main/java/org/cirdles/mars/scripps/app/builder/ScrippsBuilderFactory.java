package org.cirdles.mars.scripps.app.builder;

import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Builder;
import javafx.util.BuilderFactory;
import org.cirdles.mars.scripps.app.gui.common.ScrippsMenuBar;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by johnzeringue on 12/30/15.
 */
public class ScrippsBuilderFactory implements BuilderFactory {

    private static final BuilderFactory DEFAULT_BUILDER_FACTORY
            = new JavaFXBuilderFactory();

    private final Provider<ScrippsMenuBar> scrippsMenuBarProvider;

    @Inject
    public ScrippsBuilderFactory(
            Provider<ScrippsMenuBar> scrippsMenuBarProvider) {
        this.scrippsMenuBarProvider = scrippsMenuBarProvider;
    }

    @Override
    public Builder<?> getBuilder(Class<?> type) {
        Builder<?> builder;

        if (ScrippsMenuBar.class.equals(type)) {
            builder = scrippsMenuBarProvider::get;
        } else {
            builder = DEFAULT_BUILDER_FACTORY.getBuilder(type);
        }

        return builder;
    }

}
