package midproject.SharedClasses.UserDefinedExceptions;

/**
 * Custom exception class for cases where an invalid input is encountered.
 */
public class InvalidInputException extends Exception {

    /**
     * Constructs a new InvalidInputException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public InvalidInputException(String message) {
        super(message);
    }
}