package com.promptoven.reviewService.application.port.out;

import java.util.List;
import java.util.Optional;

public interface ReviewRepositoryPort {

    void save(ReviewOutPortDto reviewOutPortDto);

    void update(ReviewOutPortDto reviewOutPortDto);

    void delete(ReviewOutPortDto reviewOutPortDto);

    Optional<ReviewOutPortDto> getReviewByReviewId(Long reviewId);

    List<ReviewOutPortDto> getReviewsByProductUuid(String productUuid);
}
