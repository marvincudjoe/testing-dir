package org.kafka.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListeners {
    static final String TEST_TOPIC = "test-topic";

    @KafkaListener(topics = TEST_TOPIC, groupId = "test-group")
    void listener(String data) {
        System.out.println("Listener received: " + data);
    }
}
