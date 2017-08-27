package nl.openweb.hippo;

/**
 * @author Ebrahim Aharpour
 * @since 8/27/2017
 */
public class SetupTeardownException extends RuntimeException {

    public SetupTeardownException(Exception cause) {
        super(cause.getMessage(), cause);
    }
}
