package domain.exceptions;

public class WrongInputNumberException extends RuntimeException {
    public WrongInputNumberException(String message) {
        super(message);
    }
}
