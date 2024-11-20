package com.promptoven.reviewService.adaptor.kafka.out;

import com.promptoven.reviewService.application.port.out.call.MessagePort;
import com.promptoven.reviewService.application.port.out.dto.ReviewPersistenceDto;
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
    public void createReviewMessage(ReviewPersistenceDto messageOutDto) {
        messageTemplate(CREATE_TOPIC, messageOutDto);
    }

//    @Override
//    public void updateReviewMessage(MessageOutDto messageOutDto) {
//        messageTemplate(UPDATE_TOPIC, messageOutDto);
//    }
//
//    @Override
//    public void deleteReviewMessage(ReviewOutPortDto messageOutDto) {
//        messageTemplate(DELETE_TOPIC, messageOutDto);
//    }

    private void messageTemplate(String topic, ReviewPersistenceDto messageOutDto) {
        ProducerRecord<String, Object> record = new ProducerRecord<>(topic, messageOutDto);
        kafkaTemplate.send(record);
    }
}
