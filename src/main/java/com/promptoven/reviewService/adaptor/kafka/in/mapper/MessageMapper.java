package com.promptoven.reviewService.adaptor.kafka.in.mapper;

import com.promptoven.reviewService.application.port.in.dto.ReviewInPortDto;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {
    public ReviewInPortDto toNicknameUpdateDto(String authorUuid, String memberNickname) {
        return ReviewInPortDto.builder()
                .authorUuid(authorUuid)
                .memberNickname(memberNickname)
                .build();
    }

    public ReviewInPortDto toImageUpdateDto(String authorUuid, String memberProfileImage) {
        return ReviewInPortDto.builder()
                .authorUuid(authorUuid)
                .memberProfileImage(memberProfileImage)
                .build();
    }
}
