package com.promptoven.reviewService.adaptor.in.web.vo;

import lombok.Getter;
import lombok.ToString;

@Getter
public class ReviewRequestVo {

    private String productUuid;
    private String authorUuid;
    private String memberProfileImage;
    private String memberNickname;
    private int star;
    private String contents;

}
