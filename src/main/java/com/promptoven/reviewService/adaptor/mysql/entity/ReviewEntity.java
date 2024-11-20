package com.promptoven.reviewService.adaptor.mysql.entity;

import com.promptoven.reviewService.global.common.entity.BaseEntity;
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

@Entity
@Table(name = "review")
@Getter
@NoArgsConstructor
public class ReviewEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(nullable = false, length = 50)
    private String productUuid;

    @Column(nullable = false, length = 50)
    private String authorUuid;

    @Column(nullable = false)
    private int star;

    @Column(nullable = false, length = 1000)
    private String contents;

    @Column(nullable = false)
    private Boolean isDeleted;

    @Builder
    public ReviewEntity(Long reviewId, String productUuid, String authorUuid, int star, String contents, Boolean isDeleted) {
        this.reviewId = reviewId;
        this.productUuid = productUuid;
        this.authorUuid = authorUuid;
        this.star = star;
        this.contents = contents;
        this.isDeleted = isDeleted;
    }
}
