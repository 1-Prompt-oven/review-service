package com.promptoven.reviewService.application.port.out;

import com.promptoven.reviewService.adaptor.out.mysql.entity.AggregateEntity;
import com.promptoven.reviewService.application.port.in.ReviewInPaginationDto;
import java.util.List;
import java.util.Optional;

public interface ReviewRepositoryPort {

    void save(ReviewOutPortDto reviewOutPortDto);

    void update(ReviewOutPortDto reviewOutPortDto);

    void delete(ReviewOutPortDto reviewOutPortDto);

    void save(List<AggregateDto> aggregateDto);

    Optional<ReviewOutPortDto> getReviewByReviewId(Long reviewId);

    ReviewOutPaginationDto getReviewByProductUuid(ReviewInPaginationDto reviewInPaginationDto);

    List<AggregateDto> aggregateReviewData();

}




