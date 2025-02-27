package com.promptoven.reviewService.adaptor.mysql.repository;

import com.promptoven.reviewService.adaptor.mysql.entity.ReviewEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewJpaRepository extends JpaRepository<ReviewEntity, Long> {

    Optional<ReviewEntity> findByIdAndIsDeletedFalse(Long reviewId);

}
