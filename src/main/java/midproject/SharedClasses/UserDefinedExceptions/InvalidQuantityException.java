package midproject.SharedClasses.UserDefinedExceptions;

/**
 * Custom exception class for cases where an invalid quantity is encountered.
 */
public class InvalidQuantityException extends Exception {

    /**
     * Constructs a new InvalidQuantityException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public InvalidQuantityException(String message) {
        super(message);
    }
}