package midproject.SharedClasses.UserDefinedExceptions;

/**
 * Custom exception class for prescription required errors.
 */
public class PrescriptionRequiredException extends Exception {

    /**
     * Constructs a new PrescriptionRequiredException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public PrescriptionRequiredException(String message) {
        super(message);
    }
}

