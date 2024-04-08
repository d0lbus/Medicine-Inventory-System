package midproject.SharedClasses.UserDefinedExceptions;

/**
 * Custom exception class for user not found errors.
 */
public class NoUserFoundException extends Exception {

    /**
     * Constructs a new NoUserFoundException with the specified detail message.
     *
     * @param msg the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public NoUserFoundException(String msg) {
        super(msg);
    }
}