package com.backend.healthserviceasservice.infrastructure.message.kafka;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;

@RequiredArgsConstructor
@Component
public class KafkaProducer {

    final private KafkaTemplate<String, String> kafkaTemplate;

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    public void producer(String topic, String message) {
        logger.info("Publish in topic: " + topic  + " |  message:  -> {}", message);


        this.kafkaTemplate.send(topic, message);
    }

}
