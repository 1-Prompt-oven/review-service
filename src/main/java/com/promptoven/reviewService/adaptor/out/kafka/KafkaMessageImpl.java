package com.promptoven.reviewService.adaptor.out.kafka;

import com.promptoven.reviewService.application.port.out.MessagePort;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaMessageImpl implements MessagePort {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "review_event";

    @Override
    public void updateReviewAggregate() {
        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, "");
        kafkaTemplate.send(record);
    }
}
