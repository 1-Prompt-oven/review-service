package com.promptoven.reviewService.adaptor.in.web.vo;

import lombok.Getter;

@Getter
public class ReviewResponseVo {
    private Long id;
    private String productUuid;
    private String memberUuid;
    private int star;
    private String content;
}
