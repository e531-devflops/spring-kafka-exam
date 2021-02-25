package kr.daoko.kafka.pubsub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class KafkaConsumer {
    @KafkaListener(topics = "quickstart-events", groupId = "demo")
    public void consume(String message) throws IOException {
        log.info("CONSUME MESSAGE: {}", message);
    }
}
