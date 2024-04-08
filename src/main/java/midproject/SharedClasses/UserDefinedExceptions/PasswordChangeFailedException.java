package midproject.SharedClasses.UserDefinedExceptions;

public class PasswordChangeFailedException extends Exception {
    public PasswordChangeFailedException(String message) {
        super(message);
    }

    public PasswordChangeFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}

