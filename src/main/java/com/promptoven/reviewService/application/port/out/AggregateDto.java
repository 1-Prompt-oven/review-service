package com.promptoven.reviewService.application.port.out;

import jdk.jfr.Name;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class AggregateDto {
    private String productUuid;
    private Long reviewCount;
    private Double avgStar;

    @Builder
    public AggregateDto(String productUuid, Long reviewCount, Double avgStar) {
        this.productUuid = productUuid;
        this.reviewCount = reviewCount;
        this.avgStar = avgStar;
    }
}
