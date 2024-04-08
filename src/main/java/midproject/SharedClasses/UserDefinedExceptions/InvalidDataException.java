package midproject.SharedClasses.UserDefinedExceptions;

/**
 * Custom exception class for cases where invalid data is encountered.
 */
public class InvalidDataException extends Exception {

    /**
     * Constructs a new InvalidDataException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public InvalidDataException(String message) {
        super(message);
    }
}
