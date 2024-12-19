package uz.umidbek.exceptions;

public class UnknownAlgorithmException extends TInyUrlException {
    public UnknownAlgorithmException(String message) {
        super(message);
    }

    public UnknownAlgorithmException(String message, Throwable cause) {
        super(message, cause);
    }
}
