package com.promptoven.reviewService.application.port.in;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewInPortDto {

    private Long id;
    private String productUuid;
    private String memberUuid;
    private int star;
    private String contents;
    private Boolean isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public ReviewInPortDto(Long id, String productUuid, String memberUuid, int star, String contents,
            Boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.productUuid = productUuid;
        this.memberUuid = memberUuid;
        this.star = star;
        this.contents = contents;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}

