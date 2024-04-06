package midproject.SharedClasses.UserDefinedExceptions;

public class SelectionRequiredUserException extends Exception {
    public SelectionRequiredUserException(String msg) {
        super(msg);
    }
}
