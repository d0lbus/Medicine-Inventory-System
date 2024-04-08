package midproject.SharedClasses.UserDefinedExceptions;

public class MedicineRemovalFailedException extends Exception {
    public MedicineRemovalFailedException(String message) {
        super(message);
    }

    public MedicineRemovalFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}