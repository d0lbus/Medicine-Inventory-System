package midproject.SharedClasses.UserDefinedExceptions;

/**
 * Custom exception class for username already exists errors.
 */
public class UsernameAlreadyExistsException extends Exception {

    /**
     * Constructs a new UsernameAlreadyExistsException with the specified detail message.
     *
     * @param msg the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public UsernameAlreadyExistsException(String msg) {
        super(msg);
    }
}
