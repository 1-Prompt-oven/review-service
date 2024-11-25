package com.promptoven.reviewService.adaptor.in.kafka.mapper;

import com.promptoven.reviewService.application.port.in.ReviewInPortDto;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {
    public ReviewInPortDto toNicknameUpdateDto(String memberUuid, String memberNickname) {
        return ReviewInPortDto.builder()
                .memberUuid(memberUuid)
                .memberNickname(memberNickname)
                .build();
    }

    public ReviewInPortDto toImageUpdateDto(String memberUuid, String memberProfileImage) {
        return ReviewInPortDto.builder()
                .memberUuid(memberUuid)
                .memberProfileImage(memberProfileImage)
                .build();
    }
}
