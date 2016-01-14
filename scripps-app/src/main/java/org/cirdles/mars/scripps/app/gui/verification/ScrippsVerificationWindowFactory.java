package org.cirdles.mars.scripps.app.gui.verification;

import javafx.util.BuilderFactory;
import org.cirdles.mars.scripps.ScrippsSampleSource;
import org.cirdles.mars.scripps.app.gui.registration.ScrippsRegistrationWindowFactory;

import javax.inject.Inject;

/**
 * Created by johnzeringue on 1/4/16.
 */
public class ScrippsVerificationWindowFactory {

    private final BuilderFactory builderFactory;
    private final ScrippsRegistrationWindowFactory registrationWindowFactory;

    @Inject
    public ScrippsVerificationWindowFactory(
            BuilderFactory builderFactory,
            ScrippsRegistrationWindowFactory registrationWindowFactory) {

        this.builderFactory = builderFactory;
        this.registrationWindowFactory = registrationWindowFactory;
    }

    public ScrippsVerificationWindow createScrippsVerificationWindow(
            ScrippsSampleSource sampleSource) {

        return new ScrippsVerificationWindow(
                builderFactory,
                registrationWindowFactory,
                sampleSource);
    }

}
