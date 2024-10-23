package com.promptoven.reviewService.application.port.out;

public interface ReviewRepositoryPort {
    void save(ReviewTransactionDto reviewTransactionDto);
    void update(ReviewTransactionDto reviewTransactionDto);
    void delete(ReviewTransactionDto reviewTransactionDto);
    ReviewTransactionDto getReviewByReviewId(Long reviewId);
}
