package com.promptoven.reviewService.application.port.in;

public interface ReviewUseCase {

    void createReview(ReviewInPortDto reviewInPortDto);

    void updateReview(ReviewInPortDto reviewUpdateRequestDto);

    void deleteReview(Long reviewId);

    void updateMemberData(ReviewInPortDto reviewInPortDto);
}
