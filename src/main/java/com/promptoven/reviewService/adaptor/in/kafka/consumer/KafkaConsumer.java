package com.promptoven.reviewService.adaptor.in.kafka.consumer;

import com.promptoven.reviewService.adaptor.in.kafka.dto.MessageDto;
import com.promptoven.reviewService.adaptor.in.kafka.mapper.MessageMapper;
import com.promptoven.reviewService.application.port.in.ReviewInPortDto;
import com.promptoven.reviewService.application.port.in.ReviewUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;

@RequiredArgsConstructor
public class KafkaConsumer {
    private static final String UPDATE_NICKNAME_TOPIC = "update_nickname_event";
    private static final String UPDATE_IMAGE_TOPIC = "update_image_event";
    private static final String GROUP_ID = "kafka-review-service";
    private final ReviewUseCase reviewUseCase;
    private final MessageMapper messageMapper;

    @KafkaListener(topics = UPDATE_NICKNAME_TOPIC, groupId = GROUP_ID, containerFactory = "kafkaListenerContainerFactory")
    public void consumeUpdateNickname(MessageDto message) {

        ReviewInPortDto reviewInPortDto =
        messageMapper.toNicknameUpdateDto(message.getMemberUuid(),message.getMemberNickname());

        reviewUseCase.updateMemberData(reviewInPortDto);
    }

    @KafkaListener(topics = UPDATE_IMAGE_TOPIC, groupId = GROUP_ID, containerFactory = "kafkaListenerContainerFactory")
    public void consumeUpdateImage(MessageDto message) {

        ReviewInPortDto reviewInPortDto =
                messageMapper.toImageUpdateDto(message.getMemberUuid(), message.getMemberProfileImage());

        reviewUseCase.updateMemberData(reviewInPortDto);
    }
}
