package midproject.SharedClasses.UserDefinedExceptions;

/**
 * Custom exception class for authentication failures.
 */
public class AuthenticationFailedException extends Exception {

    /**
     * Constructs a new AuthenticationFailedException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public AuthenticationFailedException(String message) {
        super(message);
    }
}