package com.promptoven.reviewService.adaptor.web.vo;

import lombok.Getter;

@Getter
public class ReviewCreateRequestVo {

    private String productUuid;
    private String authorUuid;
    private String memberProfileImage;
    private String memberNickname;
    private String contents;
    private int star;

}
