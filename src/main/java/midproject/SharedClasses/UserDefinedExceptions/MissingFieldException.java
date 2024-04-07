package midproject.SharedClasses.UserDefinedExceptions;

public class MissingFieldException extends Exception {
    public MissingFieldException(String msg){
        super(msg);
    }
}
