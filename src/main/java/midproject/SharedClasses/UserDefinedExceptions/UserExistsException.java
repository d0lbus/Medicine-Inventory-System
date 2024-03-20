package midproject.SharedClasses.UserDefinedExceptions;

public class UserExistsException extends Exception {
    public UserExistsException(String msg) {
        super(msg);
    }
}
