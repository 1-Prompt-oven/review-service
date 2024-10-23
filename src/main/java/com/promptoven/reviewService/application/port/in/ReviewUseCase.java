package com.promptoven.reviewService.application.port.in;

public interface ReviewUseCase {
    void createReview(ReviewRequestDto reviewRequestDto);
    void updateReview(ReviewRequestDto reviewUpdateRequestDto);
}
