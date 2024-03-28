package midproject.SharedClasses.UserDefinedExceptions;

public class UsernameTakenException extends Exception {
    public UsernameTakenException(String message) {
        super(message);
    }
}
