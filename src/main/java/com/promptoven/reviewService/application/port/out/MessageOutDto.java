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
    private String memberProfileImage;
    private String memberNickname;
    private int star;
    private int previousStar;
    private String contents;
    private Boolean isDeleted;

    @Builder
    public MessageOutDto(Long reviewId, String productUuid, String memberUuid, String memberProfileImage,
            String memberNickname, int star, int previousStar, String contents, Boolean isDeleted) {
        this.reviewId = reviewId;
        this.productUuid = productUuid;
        this.memberUuid = memberUuid;
        this.memberProfileImage = memberProfileImage;
        this.memberNickname = memberNickname;
        this.star = star;
        this.previousStar = previousStar;
        this.contents = contents;
        this.isDeleted = isDeleted;
    }
}
