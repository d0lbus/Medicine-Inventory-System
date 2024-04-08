package midproject.SharedClasses.UserDefinedExceptions;

/**
 * Custom exception class for cases where a user is already logged in.
 */
public class AlreadyLoggedInException extends Exception {

    /**
     * Constructs a new AlreadyLoggedInException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public AlreadyLoggedInException(String message) {
        super(message);
    }
}