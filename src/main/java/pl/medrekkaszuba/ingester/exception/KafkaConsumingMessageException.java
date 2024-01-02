package pl.medrekkaszuba.ingester.exception;

public class KafkaConsumingMessageException extends RuntimeException {
    public KafkaConsumingMessageException(String message, Throwable cause) {
        super(message, cause);
    }
}
