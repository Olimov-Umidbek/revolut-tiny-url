package uz.umidbek.exceptions;

public class UnknownStorageTypeException extends TInyUrlException {
    public UnknownStorageTypeException(String message) {
        super(message);
    }

    public UnknownStorageTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
