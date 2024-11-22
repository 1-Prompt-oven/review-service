package com.promptoven.reviewService.application.port.out.dto.Message;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateEventMessageDto {

    private Long reviewId;
    private String productUuid;
    private String authorUuid;
    private String authorProfileImage;
    private String authorNickname;
    private int star;
    private String contents;
    private Boolean isDeleted;

    @Builder
    public CreateEventMessageDto(Long reviewId, String productUuid, String authorUuid, String authorProfileImage,
            String authorNickname, int star, String contents, Boolean isDeleted) {
        this.reviewId = reviewId;
        this.productUuid = productUuid;
        this.authorUuid = authorUuid;
        this.authorProfileImage = authorProfileImage;
        this.authorNickname = authorNickname;
        this.star = star;
        this.contents = contents;
        this.isDeleted = isDeleted;
    }
}
