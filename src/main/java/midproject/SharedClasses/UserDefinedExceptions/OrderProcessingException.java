package midproject.SharedClasses.UserDefinedExceptions;

/**
 * Custom exception class for order processing failures.
 */
public class OrderProcessingException extends Exception {

    /**
     * Constructs a new OrderProcessingException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public OrderProcessingException(String message) {
        super(message);
    }

    /**
     * Constructs a new OrderProcessingException with the specified detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method).
     *              (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public OrderProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
