package com.promptoven.reviewService.application.port.in;

import com.promptoven.reviewService.application.port.in.dto.ReviewInPortDto;

public interface ReviewUseCase {

    void createReview(ReviewInPortDto reviewInPortDto);

    void updateReview(ReviewInPortDto reviewUpdateRequestDto);

    void deleteReview(Long reviewId);

    void updateMemberData(ReviewInPortDto updateMemberDataDto);
}
