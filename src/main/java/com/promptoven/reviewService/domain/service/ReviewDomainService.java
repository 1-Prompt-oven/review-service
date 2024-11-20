package com.promptoven.reviewService.domain.service;

import com.promptoven.reviewService.application.port.in.dto.ReviewInPortDto;
import com.promptoven.reviewService.application.port.out.ReviewOutPortDto;
import com.promptoven.reviewService.domain.model.Review;
import org.springframework.stereotype.Service;

@Service
public class ReviewDomainService {

    public Review createReview(ReviewInPortDto reviewInPortDto) {
        return Review.builder()
                .productUuid(reviewInPortDto.getProductUuid())
                .authorUuid(reviewInPortDto.getAuthorUuid())
                .star(reviewInPortDto.getStar())
                .contents(reviewInPortDto.getContents())
                .isDeleted(false)
                .build();
    }

    public Review updateReview(ReviewOutPortDto reviewOutPortDto, ReviewInPortDto reviewInPortDto) {
        return Review.builder()
                .id(reviewOutPortDto.getId())
                .productUuid(reviewOutPortDto.getProductUuid())
                .authorUuid(reviewOutPortDto.getAuthorUuid())
                .star(reviewInPortDto.getStar())
                .contents(reviewInPortDto.getContents())
                .isDeleted(reviewOutPortDto.getIsDeleted())
                .build();
    }

    public Review deleteReview(ReviewOutPortDto reviewOutPortDto) {
        return Review.builder()
                .id(reviewOutPortDto.getId())
                .productUuid(reviewOutPortDto.getProductUuid())
                .authorUuid(reviewOutPortDto.getAuthorUuid())
                .star(reviewOutPortDto.getStar())
                .contents(reviewOutPortDto.getContents())
                .isDeleted(true)
                .build();
    }

}
