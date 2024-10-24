package com.promptoven.reviewService.application.port.out;

import java.util.Optional;

public interface ReviewRepositoryPort {
    void save(ReviewTransactionDto reviewTransactionDto);
    void update(ReviewTransactionDto reviewTransactionDto);
    Optional<ReviewTransactionDto> getReviewByReviewId(Long reviewId);
    void delete(ReviewTransactionDto reviewTransactionDto);
}
