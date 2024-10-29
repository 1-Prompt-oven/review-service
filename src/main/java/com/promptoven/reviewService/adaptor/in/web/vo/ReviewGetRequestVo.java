package com.promptoven.reviewService.adaptor.in.web.vo;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class ReviewGetRequestVo {
    private String productUuid;
    private LocalDateTime lastCreatedAt;
    private Long lastId;
    private Integer pageSize;
    private Integer page;

}
