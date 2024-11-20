package com.promptoven.reviewService.application.port.out;

import com.promptoven.reviewService.adaptor.out.mysql.entity.ReviewEntity;
import java.util.List;
import java.util.Optional;

public interface ReviewRepositoryPort {

    ReviewOutPortDto save(ReviewOutPortDto reviewOutPortDto);

    ReviewOutPortDto update(ReviewOutPortDto reviewOutPortDto);

    ReviewOutPortDto delete(ReviewOutPortDto reviewOutPortDto);

    Optional<ReviewOutPortDto> getReviewByReviewId(Long reviewId);

    List<ReviewOutPortDto> getReviewListByAuthorUuid(String authorUuid);

}




