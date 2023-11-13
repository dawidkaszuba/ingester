package pl.medrekkaszuba.listener;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import pl.medrekkaszuba.exception.KafkaConsumingMessageException;
import pl.medrekkaszuba.model.ImageDto;
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

    @KafkaListener(topics = "${kafka.processedImagesTopic.name}", groupId = "group_id")
    public void consumeProcessedImage(@Payload String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        try {
            ImageDto imageDto = objectMapper.readValue(message, ImageDto.class);
            processedImageService.saveProcessedImageData(imageDto);
        } catch (Exception e) {
            log.error("[KafkaConsumer] Error consuming message from Kafka topic {} : {}", topic, e.getStackTrace());
            throw new KafkaConsumingMessageException("An error occurred while consuming message from Kafka", e);
        }
    }
}
