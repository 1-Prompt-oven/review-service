package com.promptoven.reviewService.adaptor.in.kafka.consumer;

import com.promptoven.reviewService.adaptor.in.kafka.dto.MessageDto;
import com.promptoven.reviewService.adaptor.in.kafka.mapper.MessageMapper;
import com.promptoven.reviewService.application.port.in.dto.ReviewInPortDto;
import com.promptoven.reviewService.application.port.in.ReviewUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;

@RequiredArgsConstructor
public class KafkaConsumer {
    private static final String UPDATE_NICKNAME_TOPIC = "member-nickname-updated";
    private static final String UPDATE_IMAGE_TOPIC = "profile-picture-updated";
    private static final String GROUP_ID = "kafka-review-service";
    private final ReviewUseCase reviewUseCase;
    private final MessageMapper messageMapper;

    @KafkaListener(topics = UPDATE_NICKNAME_TOPIC, groupId = GROUP_ID, containerFactory = "kafkaListenerContainerFactory")
    public void consumeUpdateNickname(MessageDto message) {

        ReviewInPortDto nicknameUpdateDto =
        messageMapper.toNicknameUpdateDto(message.getauthorUuid(),message.getMemberNickname());

        reviewUseCase.updateMemberData(nicknameUpdateDto);
    }

    @KafkaListener(topics = UPDATE_IMAGE_TOPIC, groupId = GROUP_ID, containerFactory = "kafkaListenerContainerFactory")
    public void consumeUpdateImage(MessageDto message) {

        ReviewInPortDto imageUpdateDto =
                messageMapper.toImageUpdateDto(message.getauthorUuid(), message.getMemberProfileImage());

        reviewUseCase.updateMemberData(imageUpdateDto);
    }
}
