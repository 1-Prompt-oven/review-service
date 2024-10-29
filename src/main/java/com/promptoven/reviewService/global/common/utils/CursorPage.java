package com.promptoven.reviewService.global.common.utils;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class CursorPage<T> {

    private List<T> content;
    private LocalDateTime nextCreatedAt;
    private Long nextCursor;
    private Boolean hasNext;
    private Integer pageSize;
    private Integer page;

    public boolean hasNext() {
        return nextCursor != null;
    }

    @Builder
    public CursorPage(List<T> content, Long nextCursor, LocalDateTime nextCreatedAt, Boolean hasNext, Integer pageSize, Integer page) {
        this.content = content;
        this.nextCreatedAt = nextCreatedAt;
        this.nextCursor = nextCursor;
        this.hasNext = hasNext;
        this.pageSize = pageSize;
        this.page = page;
    }
}
