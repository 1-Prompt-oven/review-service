package com.promptoven.reviewService.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewInPortUpdateRequestDto {

    private Long reviewId;
    private String contents;
    private int star;

    @Builder
    public ReviewInPortUpdateRequestDto(Long reviewId, String contents, int star) {
        this.reviewId = reviewId;
        this.contents = contents;
        this.star = star;
    }
}
