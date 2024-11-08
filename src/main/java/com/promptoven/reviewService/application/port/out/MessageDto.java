package com.promptoven.reviewService.application.port.out;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class MessageDto {
    private String productUuid;
    private int star;
    private int previousStar;

    @Builder
    public MessageDto(String productUuid, int star, int previousStar) {
        this.productUuid = productUuid;
        this.star = star;
        this.previousStar = previousStar;
    }
}
