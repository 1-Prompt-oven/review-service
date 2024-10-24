package com.promptoven.reviewService.application.port.out;

import java.util.Optional;

public interface ReviewRepositoryPort {
    void save(ReviewOutPortDto reviewOutPortDto);
    void update(ReviewOutPortDto reviewOutPortDto);
    Optional<ReviewOutPortDto> getReviewByReviewId(Long reviewId);
    void delete(ReviewOutPortDto reviewOutPortDto);
}
