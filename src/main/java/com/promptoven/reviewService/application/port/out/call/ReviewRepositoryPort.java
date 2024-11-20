package com.promptoven.reviewService.application.port.out.call;

import com.promptoven.reviewService.application.port.out.dto.ReviewOutPortDto;
import com.promptoven.reviewService.application.port.out.dto.ReviewPersistenceDto;
import com.promptoven.reviewService.application.port.out.dto.ReviewQueryDto;
import java.util.List;
import java.util.Optional;

public interface ReviewRepositoryPort {

    ReviewOutPortDto save(ReviewPersistenceDto reviewOutPortDto);

    ReviewOutPortDto update(ReviewPersistenceDto reviewOutPortDto);

    ReviewOutPortDto delete(ReviewPersistenceDto reviewOutPortDto);

    Optional<ReviewQueryDto> getReviewByReviewId(Long reviewId);

    List<ReviewOutPortDto> getReviewListByAuthorUuid(String authorUuid);

}




