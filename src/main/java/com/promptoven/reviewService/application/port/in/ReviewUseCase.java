package com.promptoven.reviewService.application.port.in;

import java.util.List;

public interface ReviewUseCase {

    void createReview(ReviewInPortDto reviewInPortDto);

    void updateReview(ReviewInPortDto reviewUpdateRequestDto);

    void deleteReview(Long reviewId);

    List<ReviewInPortDto> getReview(String productUuid);

}
