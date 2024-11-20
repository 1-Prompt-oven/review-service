package com.promptoven.reviewService.adaptor.kafka.in.consumer;

import com.promptoven.reviewService.adaptor.kafka.in.mapper.MessageMapper;
import com.promptoven.reviewService.application.port.in.usecase.ReviewUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class KafkaConsumer {

    private static final String UPDATE_NICKNAME_TOPIC = "member-nickname-updated";
    private static final String UPDATE_IMAGE_TOPIC = "profile-picture-updated";
    private static final String GROUP_ID = "kafka-review-service";
    private final ReviewUseCase reviewUseCase;
    private final MessageMapper messageMapper;

//    @KafkaListener(topics = UPDATE_NICKNAME_TOPIC, groupId = GROUP_ID, containerFactory = "kafkaListenerContainerFactory")
//    public void consumeUpdateNickname(MessageDto message) {
//
//        ReviewInPortDto nicknameUpdateDto =
//                messageMapper.toNicknameUpdateDto(message.getAuthorUuid(), message.getMemberNickname());
//
//        reviewUseCase.updateMemberData(nicknameUpdateDto);
//    }
//
//    @KafkaListener(topics = UPDATE_IMAGE_TOPIC, groupId = GROUP_ID, containerFactory = "kafkaListenerContainerFactory")
//    public void consumeUpdateImage(MessageDto message) {
//
//        ReviewInPortDto imageUpdateDto =
//                messageMapper.toImageUpdateDto(message.getauthorUuid(), message.getMemberProfileImage());
//
//        reviewUseCase.updateMemberData(imageUpdateDto);
//    }
}
