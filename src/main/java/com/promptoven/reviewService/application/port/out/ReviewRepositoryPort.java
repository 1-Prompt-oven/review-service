package com.promptoven.reviewService.application.port.out;

public interface ReviewRepositoryPort {
    void save(ReviewTransactionDto reviewTransactionDto);
    ReviewTransactionDto getReviewByReviewId(Long reviewId);
}
