package com.promptoven.reviewService.application.port.out.dto.Message;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteEventMessageDto {

    private Long reviewId;
    private String productUuid;
    private int star;

    @Builder
    public DeleteEventMessageDto(Long reviewId, String productUuid, int star) {
        this.reviewId = reviewId;
        this.productUuid = productUuid;
        this.star = star;
    }
}
