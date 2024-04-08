package midproject.SharedClasses.UserDefinedExceptions;

public class CartDetailsFetchFailedException extends Exception {
    public CartDetailsFetchFailedException(String message) {
        super(message);
    }

    public CartDetailsFetchFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
