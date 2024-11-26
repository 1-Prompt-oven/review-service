package com.promptoven.reviewService.application.port.in.usecase;

import com.promptoven.reviewService.application.port.in.dto.ReviewInPortCreateRequestDto;
import com.promptoven.reviewService.application.port.in.dto.ReviewInPortUpdateRequestDto;

public interface ReviewUseCase {

    void createReview(ReviewInPortCreateRequestDto reviewCreateRequestDto);

    void updateReview(ReviewInPortUpdateRequestDto reviewUpdateRequestDto);

    void deleteReview(Long reviewId, Long purchaseProductId);

}
