package com.promptoven.reviewService.adaptor.in.web.vo;

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

    @Builder
    public ReviewResponseVo(Long id, String productUuid, String memberUuid, int star, String content) {
        this.id = id;
        this.productUuid = productUuid;
        this.memberUuid = memberUuid;
        this.star = star;
        this.content = content;
    }
}
