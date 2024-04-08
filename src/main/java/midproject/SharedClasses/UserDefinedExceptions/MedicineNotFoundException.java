package midproject.SharedClasses.UserDefinedExceptions;

/**
 * Custom exception class for cases where a medicine is not found.
 */
public class MedicineNotFoundException extends Exception {

    /**
     * Constructs a new MedicineNotFoundException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public MedicineNotFoundException(String message) {
        super(message);
    }
}