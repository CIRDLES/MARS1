package org.cirdles.mars.scripps;

import org.cirdles.mars.api.MarsException;

/**
 * Created by johnzeringue on 12/21/15.
 */
public class ScrippsException extends MarsException {

    public ScrippsException() {
        super();
    }

    public ScrippsException(String message) {
        super(message);
    }

    public ScrippsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScrippsException(Throwable cause) {
        super(cause);
    }

}
