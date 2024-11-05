package com.promptoven.reviewService.adaptor.out.mysql.repository;

import com.promptoven.reviewService.adaptor.out.mysql.entity.ReviewEntity;
import com.promptoven.reviewService.application.port.out.AggregateDto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewJpaRepository extends JpaRepository<ReviewEntity, Long> {

    Optional<ReviewEntity> findByReviewIdAndIsDeletedFalse(Long reviewId);

    @Query("SELECT new com.promptoven.reviewService.application.port.out.AggregateDto(p.productUuid, " +
            "COALESCE(CAST(COUNT(r) AS long), 0)," +
            "COALESCE(CAST(AVG(r.star) AS double), 0.0)) " +
            "FROM AggregateEntity p LEFT JOIN ReviewEntity r ON p.productUuid = r.productUuid AND r.isDeleted = false " +
            "GROUP BY p.productUuid")
    List<AggregateDto> aggregateReviewData();
}
