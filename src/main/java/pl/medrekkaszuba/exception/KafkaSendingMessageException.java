package pl.medrekkaszuba.exception;

public class KafkaSendingMessageException extends RuntimeException {
    public KafkaSendingMessageException(String message, Throwable cause) {
        super(message, cause);
    }
}
