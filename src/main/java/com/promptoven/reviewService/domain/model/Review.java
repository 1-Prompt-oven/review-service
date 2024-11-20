package com.promptoven.reviewService.domain.model;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Review {

    private Long id; // 비지니스 로직 또는 프론트에서 사용 할 수 있는 값
    private String productUuid;
    private String authorUuid;
    private int star;
    private String contents;
    private Boolean isDeleted; // soft delete
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public Review(Long id, String productUuid, String authorUuid, int star, String contents, Boolean isDeleted,
            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.productUuid = productUuid;
        this.authorUuid = authorUuid;
        this.star = star;
        this.contents = contents;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
