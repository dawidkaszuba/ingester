package pl.medrekkaszuba.publisher;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pl.medrekkaszuba.exception.KafkaSendingMessageException;

@Slf4j
@Service
public class KafkaPublisherService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String imagesToProcessTopic;

    private final ObjectMapper objectMapper;


    public KafkaPublisherService(KafkaTemplate<String, String> kafkaTemplate,
                                 @Value("kafka.imagesToProcessTopic") String imagesToProcessTopic,
                                 ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.imagesToProcessTopic = imagesToProcessTopic;
        this.objectMapper = objectMapper;
    }


    public void sendImageToProcess() {
        //todo
        //sendKafkaMessage(imagesToProcessTopic, null, null);
    }

    private void sendKafkaMessage(String topic, String key, String message) {
        try {
            String serializedMessage = objectMapper.writeValueAsString(message);
            kafkaTemplate.send(topic, key, serializedMessage).get();
        } catch (Exception e) {
            log.error("[KafkaPublisherService] Error sending message to kafka", e);
            throw new KafkaSendingMessageException("An error occurred while sending message to Kafka", e);
        }
    }
}
