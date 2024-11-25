package com.promptoven.reviewService.adaptor.web.vo;

import lombok.Getter;

@Getter
public class ReviewUpdateRequestVo {

    private Long id;
    private String contents;
    private int star;
}
