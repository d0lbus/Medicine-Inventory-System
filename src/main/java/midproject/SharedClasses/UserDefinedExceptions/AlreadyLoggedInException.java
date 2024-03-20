package midproject.SharedClasses.UserDefinedExceptions;

public class AlreadyLoggedInException extends Exception {
    public AlreadyLoggedInException(String msg) {
        super(msg);
    }
}
