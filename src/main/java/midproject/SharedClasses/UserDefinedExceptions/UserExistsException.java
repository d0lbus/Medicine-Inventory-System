package midproject.SharedClasses.UserDefinedExceptions;

/**
 * Custom exception class for user existence errors.
 */
public class UserExistsException extends Exception {

    /**
     * Constructs a new UserExistsException with the specified detail message.
     *
     * @param msg the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public UserExistsException(String msg) {
        super(msg);
    }
}