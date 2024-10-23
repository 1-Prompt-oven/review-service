package com.promptoven.reviewService.adaptor.in.web.vo;

import lombok.Getter;

@Getter
public class ReviewUpdateRequestVo {

    private Long reviewId;
    private String productUuid;
    private String contents;
    private int star;
}
