package com.promptoven.reviewService.adaptor.out.mysql.repository;

import com.promptoven.reviewService.adaptor.out.mysql.entity.ReviewEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewJpaRepository extends JpaRepository<ReviewEntity, Long> {
    Optional<ReviewEntity> findByReviewId(Long reviewId);
    List<ReviewEntity> findByProductUuidAndIsDeletedFalse(String productUuid);
}
