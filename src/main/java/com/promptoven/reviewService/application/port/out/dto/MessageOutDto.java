package com.promptoven.reviewService.application.port.out.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class MessageOutDto {

    private Long reviewId;
    private String productUuid;
    private String authorUuid;
    private int star;
    private int previousStar;
    private String contents;
    private Boolean isDeleted;

    @Builder
    public MessageOutDto(Long reviewId, String productUuid, String authorUuid, int star, int previousStar,
            String contents, Boolean isDeleted) {
        this.reviewId = reviewId;
        this.productUuid = productUuid;
        this.authorUuid = authorUuid;
        this.star = star;
        this.previousStar = previousStar;
        this.contents = contents;
        this.isDeleted = isDeleted;
    }
}
