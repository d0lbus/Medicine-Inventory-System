package midproject.SharedClasses.UserDefinedExceptions;

/**
 * Custom exception class for selection required user errors.
 */
public class SelectionRequiredUserException extends Exception {

    /**
     * Constructs a new SelectionRequiredUserException with the specified detail message.
     *
     * @param msg the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public SelectionRequiredUserException(String msg) {
        super(msg);
    }
}