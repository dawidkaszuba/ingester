package pl.medrekkaszuba.ingester.exception;

public class KafkaSendingMessageException extends RuntimeException {
    public KafkaSendingMessageException(String message, Throwable cause) {
        super(message, cause);
    }
}
