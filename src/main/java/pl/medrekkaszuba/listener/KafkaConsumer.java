package pl.medrekkaszuba.listener;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import pl.medrekkaszuba.service.ProcessedImageService;

@Slf4j
@Service
public class KafkaConsumer {

    private final ObjectMapper objectMapper;

    private final ProcessedImageService processedImageService;

    public KafkaConsumer(ObjectMapper objectMapper, ProcessedImageService processedImageService) {
        this.objectMapper = objectMapper;
        this.processedImageService = processedImageService;
    }

    @KafkaListener(topics = "processed-images", groupId = "group_id")
    public void consumeProcessedImage(@Payload String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        //todo
    }
}
