package com.promptoven.reviewService.adaptor.web.vo;

import lombok.Getter;

@Getter
public class ReviewCreateRequestVo {

    private String productUuid;
    private Long purchaseProductId;
    private String authorUuid;
    private String authorProfileImage;
    private String authorNickname;
    private String contents;
    private int star;

}
