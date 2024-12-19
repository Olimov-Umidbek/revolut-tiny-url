package uz.umidbek.exceptions;

public class TInyUrlException extends RuntimeException {
    public TInyUrlException(String message) {
        super(message);
    }

    public TInyUrlException(String message, Throwable cause) {
        super(message, cause);
    }
}
