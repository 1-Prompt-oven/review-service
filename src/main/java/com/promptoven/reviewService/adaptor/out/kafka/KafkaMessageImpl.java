package com.promptoven.reviewService.adaptor.out.kafka;

import com.promptoven.reviewService.application.port.out.MessageDto;
import com.promptoven.reviewService.application.port.out.MessagePort;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaMessageImpl implements MessagePort {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private static final String CREATE_TOPIC = "create_review_event"; // 각각 이벤트의 발행
    private static final String UPDATE_TOPIC = "update_review_event";
    private static final String DELETE_TOPIC = "delete_review_event";

    @Override
    public void createReviewMessage(MessageDto messageDto) {
        ProducerRecord<String, Object> record = new ProducerRecord<>(CREATE_TOPIC, messageDto);
        kafkaTemplate.send(record);
    }

    @Override
    public void updateReviewMessage(MessageDto messageDto) {
        ProducerRecord<String, Object> record = new ProducerRecord<>(UPDATE_TOPIC, messageDto);
        kafkaTemplate.send(record);
    }

    @Override
    public void deleteReviewMessage(MessageDto messageDto) {
        ProducerRecord<String, Object> record = new ProducerRecord<>(DELETE_TOPIC, messageDto);
        kafkaTemplate.send(record);
    }
}
