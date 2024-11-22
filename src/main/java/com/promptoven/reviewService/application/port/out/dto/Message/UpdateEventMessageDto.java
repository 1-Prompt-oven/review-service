package com.promptoven.reviewService.application.port.out.dto.Message;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class UpdateEventMessageDto {

    private Long reviewId;
    private String productUuid;
    private String contents;
    private int star;
    private int previousStar;

    @Builder
    public UpdateEventMessageDto(Long reviewId, String productUuid, int star, String contents, int previousStar) {
        this.reviewId = reviewId;
        this.productUuid = productUuid;
        this.contents = contents;
        this.star = star;
        this.previousStar = previousStar;
    }
}
