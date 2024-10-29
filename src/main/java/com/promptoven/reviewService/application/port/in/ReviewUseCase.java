package com.promptoven.reviewService.application.port.in;

import com.promptoven.reviewService.adaptor.in.web.vo.ReviewResponseVo;
import java.util.List;

public interface ReviewUseCase {

    void createReview(ReviewInPortDto reviewInPortDto);

    void updateReview(ReviewInPortDto reviewUpdateRequestDto);

    void deleteReview(Long reviewId);

    List<ReviewInPortDto> getReview(ReviewPaginationDto reviewPaginationDto);

}
