package midproject.SharedClasses.UserDefinedExceptions;

public class JsonFileAccessException extends Exception {
    public JsonFileAccessException(String message) {
        super(message);
    }

    public JsonFileAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
