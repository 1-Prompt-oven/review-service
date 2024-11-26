package com.promptoven.reviewService.application.port.in.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewInPortCreateRequestDto {

    private String productUuid;
    private Long purchaseProductId;
    private String authorUuid;
    private String authorProfileImage;
    private String authorNickname;
    private String contents;
    private int star;

    @Builder
    public ReviewInPortCreateRequestDto(String productUuid, Long purchaseProductId, String authorUuid, String authorProfileImage,
            String authorNickname, String contents, int star) {
        this.productUuid = productUuid;
        this.purchaseProductId = purchaseProductId;
        this.authorUuid = authorUuid;
        this.authorProfileImage = authorProfileImage;
        this.authorNickname = authorNickname;
        this.contents = contents;
        this.star = star;
    }
}
