package midproject.SharedClasses.UserDefinedExceptions;

/**
 * Custom exception class for cases where a medicine is out of stock.
 */
public class MedicineOutOfStockException extends Exception {

    /**
     * Constructs a new MedicineOutOfStockException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public MedicineOutOfStockException(String message) {
        super(message);
    }
}

