package midproject.SharedClasses.UserDefinedExceptions;

public class AuthenticationFailedException extends Exception {
    public AuthenticationFailedException(String message) {
        super(message);
    }
}
