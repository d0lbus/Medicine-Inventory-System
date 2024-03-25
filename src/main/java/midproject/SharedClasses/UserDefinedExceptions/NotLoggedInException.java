package midproject.SharedClasses.UserDefinedExceptions;

// custom exception class used to denote an error where
// a client tries to log out/send broadcast while not
// logged in
public class NotLoggedInException extends Exception {
    public NotLoggedInException(String s) {
    }
}