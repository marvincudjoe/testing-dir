package org.kafka.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {

    static final String TEST_TOPIC = "test-topic";

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/publish")
    void publish(@RequestBody MessageRequest message) {
        kafkaTemplate.send(TEST_TOPIC, message.message);
    }

    record MessageRequest(String message) {
    }
}
