package com.promptoven.reviewService.adaptor.in.web.vo;

import lombok.Getter;

@Getter
public class ReviewRequestVo {

    private String productUuid;
    private String memberUuid;
    private int star;
    private String contents;

}
