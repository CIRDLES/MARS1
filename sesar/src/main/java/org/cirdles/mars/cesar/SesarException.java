package org.cirdles.mars.cesar;

import org.cirdles.mars.api.MarsException;

/**
 * Created by johnzeringue on 1/9/16.
 */
public class SesarException extends MarsException {



    public SesarException() {
        super();
    }

    public SesarException(String message) {
        super(message);
    }

    public SesarException(String message, Throwable cause) {
        super(message, cause);
    }

    public SesarException(Throwable cause) {
        super(cause);
    }

}
