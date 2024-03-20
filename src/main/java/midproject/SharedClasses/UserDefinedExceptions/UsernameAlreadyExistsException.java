package midproject.SharedClasses.UserDefinedExceptions;

public class UsernameAlreadyExistsException extends Exception{
    public UsernameAlreadyExistsException(String msg) {
        super(msg);
    }
}
