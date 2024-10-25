package com.promptoven.reviewService.adaptor.in.web.vo;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewResponseVo {

    private Long id;
    private String productUuid;
    private String memberUuid;
    private int star;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public ReviewResponseVo(Long id, String productUuid, String memberUuid, int star, String content,
            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.productUuid = productUuid;
        this.memberUuid = memberUuid;
        this.star = star;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
