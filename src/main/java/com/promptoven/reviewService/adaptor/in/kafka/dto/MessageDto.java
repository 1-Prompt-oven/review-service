package com.promptoven.reviewService.adaptor.in.kafka.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MessageDto {
    private String memberUuid;
    private String memberProfileImage;
    private String memberNickname;
}
