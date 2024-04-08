package midproject.SharedClasses.UserDefinedExceptions;

/**
 * Custom exception class for user unarchiving errors.
 */
public class UserUnarchiveException extends Exception {

    /**
     * Constructs a new UserUnarchiveException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public UserUnarchiveException(String message) {
        super(message);
    }
}
