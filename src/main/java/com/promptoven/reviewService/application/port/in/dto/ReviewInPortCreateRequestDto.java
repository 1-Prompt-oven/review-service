package com.promptoven.reviewService.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewInPortCreateRequestDto {

    private String productUuid;
    private String authorUuid;
    private String memberProfileImage;
    private String memberNickname;
    private String contents;
    private int star;

    @Builder
    public ReviewInPortCreateRequestDto(String productUuid, String authorUuid, String memberProfileImage,
            String memberNickname, String contents, int star) {
        this.productUuid = productUuid;
        this.authorUuid = authorUuid;
        this.memberProfileImage = memberProfileImage;
        this.memberNickname = memberNickname;
        this.contents = contents;
        this.star = star;
    }
}
