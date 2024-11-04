package com.promptoven.reviewService.adaptor.out.mysql.repository;

import com.promptoven.reviewService.adaptor.out.mysql.entity.ReviewEntity;
import com.promptoven.reviewService.application.port.out.AggregateDto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewJpaRepository extends JpaRepository<ReviewEntity, Long> {

    Optional<ReviewEntity> findByReviewId(Long reviewId);

    @Query("SELECT new com.promptoven.reviewService.application.port.out.AggregateDto(r.productUuid, COUNT(r), AVG(r.star)) " +
            "FROM ReviewEntity r WHERE r.isDeleted = false GROUP BY r.productUuid")
    List<AggregateDto> aggregateReviewData();
}
