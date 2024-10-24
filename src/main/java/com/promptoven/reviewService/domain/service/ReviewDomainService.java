package com.promptoven.reviewService.domain.service;

import com.promptoven.reviewService.application.port.in.ReviewRequestDto;
import com.promptoven.reviewService.application.port.out.ReviewTransactionDto;
import com.promptoven.reviewService.domain.model.Review;
import org.springframework.stereotype.Service;

@Service
public class ReviewDomainService {

    public Review createReview(ReviewRequestDto reviewRequestDto) {
        return Review.builder()
                .productUuid(reviewRequestDto.getProductUuid())
                .memberUuid(reviewRequestDto.getMemberUuid())
                .star(reviewRequestDto.getStar())
                .contents(reviewRequestDto.getContents())
                .isDeleted(false)
                .build();
    }

    public Review updateReview(ReviewTransactionDto reviewTransactionDto, ReviewRequestDto reviewRequestDto) {
        return Review.builder()
                .id(reviewTransactionDto.getId())
                .productUuid(reviewTransactionDto.getProductUuid())
                .memberUuid(reviewTransactionDto.getMemberUuid())
                .star(reviewRequestDto.getStar())
                .contents(reviewRequestDto.getContents())
                .isDeleted(reviewRequestDto.getIsDeleted())
                .build();
    }
}
