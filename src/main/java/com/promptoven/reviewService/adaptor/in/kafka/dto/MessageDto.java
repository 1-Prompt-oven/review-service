package com.promptoven.reviewService.adaptor.in.kafka.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MessageDto {
    private String authorUuid;
    private String memberProfileImage;
    private String memberNickname;
}
