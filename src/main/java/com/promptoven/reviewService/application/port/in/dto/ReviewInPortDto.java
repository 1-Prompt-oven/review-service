package com.promptoven.reviewService.application.port.in.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewInPortDto {

    private Long id;
    private String productUuid;
    private String authorUuid;
    private String memberProfileImage;
    private String memberNickname;
    private int star;
    private String contents;
    private Boolean isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public ReviewInPortDto(Long id, String productUuid, String authorUuid, String memberProfileImage,
            String memberNickname, int star, String contents, Boolean isDeleted, LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id;
        this.productUuid = productUuid;
        this.authorUuid = authorUuid;
        this.memberProfileImage = memberProfileImage;
        this.memberNickname = memberNickname;
        this.star = star;
        this.contents = contents;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}

