package com.promptoven.reviewService.global.common.utils;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CursorPage<T> {

    private List<T> content;
    private LocalDateTime lastCreatedAt;
    private Long lastId;
    private Boolean hasNext;
    private Integer pageSize;
    private Integer page;

    public boolean hasNext() {
        return lastId != null;
    }

    @Builder
    public CursorPage(List<T> content, Long lastId, LocalDateTime lastCreatedAt, Boolean hasNext, Integer pageSize,
            Integer page) {
        this.content = content;
        this.lastCreatedAt = lastCreatedAt;
        this.lastId = lastId;
        this.hasNext = hasNext;
        this.pageSize = pageSize;
        this.page = page;
    }
}
