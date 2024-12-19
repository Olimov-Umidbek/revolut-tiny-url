package uz.umidbek.exceptions;

public class EmptyUrlException extends TInyUrlException{
    public EmptyUrlException(String message) {
        super(message);
    }

    public EmptyUrlException(String message, Throwable cause) {
        super(message, cause);
    }
}
