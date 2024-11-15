package com.promptoven.reviewService.application.port.out;

import com.promptoven.reviewService.adaptor.out.mysql.entity.ReviewEntity;
import java.util.Optional;

public interface ReviewRepositoryPort {

    ReviewEntity save(ReviewOutPortDto reviewOutPortDto);

    ReviewEntity update(ReviewOutPortDto reviewOutPortDto);

    ReviewEntity delete(ReviewOutPortDto reviewOutPortDto);

    Optional<ReviewOutPortDto> getReviewByReviewId(Long reviewId);

}




