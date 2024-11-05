package com.promptoven.reviewService.application.port.in;

import com.promptoven.reviewService.global.common.utils.CursorPage;
import java.util.List;

public interface ReviewUseCase {

    void createReview(ReviewInPortDto reviewInPortDto);

    void updateReview(ReviewInPortDto reviewUpdateRequestDto);

    void deleteReview(Long reviewId);

    ReviewInPaginationDto getReview(ReviewInPaginationDto reviewInPaginationDto);

    void aggregateReviewData();

}
