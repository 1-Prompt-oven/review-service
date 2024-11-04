package com.promptoven.reviewService.adaptor.out.mysql.repository;

import com.promptoven.reviewService.adaptor.out.mysql.entity.AggregateEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewAggregateJpaRepository extends JpaRepository<AggregateEntity, Long> {

    List<AggregateEntity> findAllByProductUuidIn(List<String> productUuids);
}
