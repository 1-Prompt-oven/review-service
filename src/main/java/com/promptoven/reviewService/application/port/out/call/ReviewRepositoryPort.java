package com.promptoven.reviewService.application.port.out.call;

import com.promptoven.reviewService.application.port.out.dto.ReviewPersistenceDto;
import com.promptoven.reviewService.application.port.out.dto.ReviewQueryDto;
import java.util.List;
import java.util.Optional;

public interface ReviewRepositoryPort {

    ReviewPersistenceDto save(ReviewPersistenceDto reviewOutPortDto);

    ReviewPersistenceDto update(ReviewPersistenceDto reviewOutPortDto);

    ReviewPersistenceDto delete(ReviewPersistenceDto reviewOutPortDto);

    Optional<ReviewQueryDto> getReviewByReviewId(Long reviewId);

    List<ReviewPersistenceDto> getReviewListByAuthorUuid(String authorUuid);

}




