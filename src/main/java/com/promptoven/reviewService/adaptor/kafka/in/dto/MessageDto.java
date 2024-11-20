package com.promptoven.reviewService.adaptor.kafka.in.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MessageDto {
    private String authorUuid;
    private String memberProfileImage;
    private String memberNickname;
}
