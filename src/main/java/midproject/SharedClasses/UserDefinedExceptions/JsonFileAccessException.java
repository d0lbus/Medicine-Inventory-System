package midproject.SharedClasses.UserDefinedExceptions;

/**
 * Custom exception class for errors related to JSON file access.
 */
public class JsonFileAccessException extends Exception {

    /**
     * Constructs a new JsonFileAccessException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public JsonFileAccessException(String message) {
        super(message);
    }

    /**
     * Constructs a new JsonFileAccessException with the specified detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method).
     *              (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public JsonFileAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
