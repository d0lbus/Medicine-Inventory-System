package midproject.SharedClasses.UserDefinedExceptions;

/**
 * Custom exception class for failures in updating medicine quantity.
 */
public class MedicineQuantityUpdateFailedException extends Exception {

    /**
     * Constructs a new MedicineQuantityUpdateFailedException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public MedicineQuantityUpdateFailedException(String message) {
        super(message);
    }

    /**
     * Constructs a new MedicineQuantityUpdateFailedException with the specified detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method).
     *              (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public MedicineQuantityUpdateFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
