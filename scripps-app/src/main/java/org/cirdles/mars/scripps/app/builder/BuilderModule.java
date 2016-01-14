package org.cirdles.mars.scripps.app.builder;

import dagger.Module;
import dagger.Provides;
import javafx.util.BuilderFactory;

/**
 * Created by johnzeringue on 1/9/16.
 */
@Module
public class BuilderModule {

    @Provides
    public BuilderFactory provideBuilderFactory(
            ScrippsBuilderFactory scrippsBuilderFactory) {

        return scrippsBuilderFactory;
    }

}
