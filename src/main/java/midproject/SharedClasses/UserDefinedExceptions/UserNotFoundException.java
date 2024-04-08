package midproject.SharedClasses.UserDefinedExceptions;

/**
 * Custom exception class for user not found errors.
 */
public class UserNotFoundException extends Exception {

    /**
     * Constructs a new UserNotFoundException with the specified detail message.
     *
     * @param msg the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public UserNotFoundException(String msg) {
        super(msg);
    }
}
