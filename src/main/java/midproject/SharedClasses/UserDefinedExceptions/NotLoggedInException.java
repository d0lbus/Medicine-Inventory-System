package midproject.SharedClasses.UserDefinedExceptions;

/**
 * Custom exception class used to denote an error where a client tries to perform an action
 * (such as logging out or sending a broadcast) while not logged in.
 */
public class NotLoggedInException extends Exception {

    /**
     * Constructs a new NotLoggedInException with the specified detail message.
     *
     * @param s the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public NotLoggedInException(String s) {
        super(s);
    }
}