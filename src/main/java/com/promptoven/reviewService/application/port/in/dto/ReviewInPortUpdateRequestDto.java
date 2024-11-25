package com.promptoven.reviewService.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewInPortUpdateRequestDto {

    private Long id;
    private String contents;
    private int star;

    @Builder
    public ReviewInPortUpdateRequestDto(Long id, String contents, int star) {
        this.id = id;
        this.contents = contents;
        this.star = star;
    }
}
