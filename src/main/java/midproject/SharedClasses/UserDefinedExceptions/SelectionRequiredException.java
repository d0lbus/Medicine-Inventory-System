package midproject.SharedClasses.UserDefinedExceptions;

public class SelectionRequiredException extends Exception {
    public SelectionRequiredException(String msg) {
        super(msg);
    }
}
