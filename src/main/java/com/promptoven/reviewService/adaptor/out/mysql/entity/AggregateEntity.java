package com.promptoven.reviewService.adaptor.out.mysql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Entity
@Table(name = "reviewAggregate")
@Getter
@NoArgsConstructor
public class AggregateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String productUuid;

    @Column(nullable = false)
    private Long reviewCount;

    @Column(nullable = false)
    private double avgStar;

    @Builder
    public AggregateEntity(Long id, String productUuid, Long reviewCount, double avgStar) {
        this.id = id;
        this.productUuid = productUuid;
        this.reviewCount = reviewCount;
        this.avgStar = avgStar;
    }
}
