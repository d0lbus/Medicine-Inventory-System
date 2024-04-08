package midproject.SharedClasses.UserDefinedExceptions;

/**
 * Custom exception class for server connection errors.
 */
public class ServerConnectionException extends Exception {

    /**
     * Constructs a new ServerConnectionException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public ServerConnectionException(String message) {
        super(message);
    }
}