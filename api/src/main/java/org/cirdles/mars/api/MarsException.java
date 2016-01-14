package org.cirdles.mars.api;

/**
 * Created by johnzeringue on 12/21/15.
 */
public class MarsException extends RuntimeException {

    public MarsException() {
        super();
    }

    public MarsException(String message) {
        super(message);
    }

    public MarsException(String message, Throwable cause) {
        super(message, cause);
    }

    public MarsException(Throwable cause) {
        super(cause);
    }

}
