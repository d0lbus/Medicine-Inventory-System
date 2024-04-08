package midproject.SharedClasses.UserDefinedExceptions;

/**
 * Custom exception class used to denote an error where a required field is missing.
 */
public class MissingFieldException extends Exception {

    /**
     * Constructs a new MissingFieldException with the specified detail message.
     *
     * @param msg the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public MissingFieldException(String msg) {
        super(msg);
    }
}
