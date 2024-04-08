package midproject.SharedClasses.UserDefinedExceptions;

public class MedicineQuantityUpdateFailedException extends Exception {
    public MedicineQuantityUpdateFailedException(String message) {
        super(message);
    }

    public MedicineQuantityUpdateFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
