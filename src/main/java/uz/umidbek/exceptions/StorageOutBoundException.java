package uz.umidbek.exceptions;

public class StorageOutBoundException extends TInyUrlException{
    public StorageOutBoundException(String message) {
        super(message);
    }

    public StorageOutBoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
