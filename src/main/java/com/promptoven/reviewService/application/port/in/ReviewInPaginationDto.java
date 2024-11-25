package com.promptoven.reviewService.application.port.in;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewInPaginationDto {

    private List<ReviewInPortDto> reviewInPortDtoList;
    private String productUuid;
    private LocalDateTime lastCreatedAt;
    private Boolean hasNext;
    private Long lastId;
    private Integer pageSize;
    private Integer page;

    @Builder
    public ReviewInPaginationDto(List<ReviewInPortDto> reviewInPortDtoList, String productUuid,
            LocalDateTime lastCreatedAt, Boolean hasNext, Long lastId, Integer pageSize, Integer page) {
        this.reviewInPortDtoList = reviewInPortDtoList;
        this.productUuid = productUuid;
        this.lastCreatedAt = lastCreatedAt;
        this.hasNext = hasNext;
        this.lastId = lastId;
        this.pageSize = pageSize;
        this.page = page;
    }
}



