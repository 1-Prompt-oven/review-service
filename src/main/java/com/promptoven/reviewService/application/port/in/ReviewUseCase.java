package com.promptoven.reviewService.application.port.in;

import java.util.List;

public interface ReviewUseCase {
    void createReview(ReviewRequestDto reviewRequestDto);
    void updateReview(ReviewRequestDto reviewUpdateRequestDto);
    void deleteReview(Long reviewId);
    List<ReviewRequestDto> getReview(String productUuid);

}
