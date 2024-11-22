package com.promptoven.reviewService.application.port.out.call;

import com.promptoven.reviewService.application.port.out.dto.ReviewPersistenceDto;
import com.promptoven.reviewService.application.port.out.dto.ReviewQueryDto;
import java.util.Optional;

public interface ReviewRepositoryPort {

    ReviewQueryDto save(ReviewPersistenceDto reviewOutPortDto);

    ReviewQueryDto update(ReviewPersistenceDto reviewOutPortDto);

    ReviewQueryDto delete(ReviewPersistenceDto reviewOutPortDto);

    Optional<ReviewQueryDto> getReviewByReviewId(Long reviewId);

}




