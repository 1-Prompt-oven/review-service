package com.promptoven.reviewService.application.port.out;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class MessageOutDto {

    private Long reviewId;
    private String productUuid;
    private String memberUuid;
    private int star;
    private int previousStar;
    private String contents;
    private Boolean isDeleted;

    @Builder
    public MessageOutDto(Long reviewId, String productUuid, String memberUuid, int star, int previousStar, String contents,
            Boolean isDeleted) {
        this.reviewId = reviewId;
        this.productUuid = productUuid;
        this.memberUuid = memberUuid;
        this.star = star;
        this.previousStar = previousStar;
        this.contents = contents;
        this.isDeleted = isDeleted;
    }
}
