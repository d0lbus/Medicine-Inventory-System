package midproject.SharedClasses.UserDefinedExceptions;

// Custom exception class used to denote an error where
// a client tries to log in while currently logged in...
public class AlreadyLoggedInException extends Exception {
    public AlreadyLoggedInException(String msg) {
        super(msg);
    }
}
