package domain.exceptions;

public class WrongSelectNumberException extends RuntimeException {
    public WrongSelectNumberException(String message) {
        super(message);
    }
}
