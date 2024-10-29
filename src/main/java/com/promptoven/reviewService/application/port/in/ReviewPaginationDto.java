package com.promptoven.reviewService.application.port.in;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class ReviewPaginationDto {
    private String productUuid;
    private LocalDateTime lastCreatedAt;
    private Long lastId;
    private Integer pageSize;
    private Integer page;

    @Builder
    public ReviewPaginationDto(String productUuid, LocalDateTime lastCreatedAt, Long lastId, Integer pageSize, Integer page) {
        this.productUuid = productUuid;
        this.lastCreatedAt = lastCreatedAt;
        this.lastId = lastId;
        this.pageSize = pageSize;
        this.page = page;
    }
}



