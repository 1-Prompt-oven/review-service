package com.promptoven.reviewService.adaptor.kafka.out;

import com.promptoven.reviewService.application.port.out.call.MessagePort;
import com.promptoven.reviewService.application.port.out.dto.Message.CreateEventMessageDto;
import com.promptoven.reviewService.application.port.out.dto.Message.DeleteEventMessageDto;
import com.promptoven.reviewService.application.port.out.dto.Message.UpdateEventMessageDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaMessageImpl implements MessagePort {

    private final KafkaTemplate<String, Object> kafkaTemplate;


    @Value("${review-create-event}")
    private String createTopic;

    @Value("${review-update-event}")
    private String updateTopic;

    @Value("${review-delete-event}")
    private String deleteTopic;

    @Override
    public void createReviewMessage(CreateEventMessageDto createEventMessageDto) {
        messageTemplate(createTopic, createEventMessageDto);
    }

    @Override
    public void updateReviewMessage(UpdateEventMessageDto messageOutDto) {
        messageTemplate(updateTopic, messageOutDto);
    }

    @Override
    public void deleteReviewMessage(DeleteEventMessageDto messageOutDto) {
        messageTemplate(deleteTopic, messageOutDto);
    }

    private <M> void messageTemplate(String topic, M message) {
        ProducerRecord<String, Object> record = new ProducerRecord<>(topic, message);
        kafkaTemplate.send(record);
    }
}
