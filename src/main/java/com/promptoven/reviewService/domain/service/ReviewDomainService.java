package com.promptoven.reviewService.domain.service;

import com.promptoven.reviewService.application.port.in.dto.ReviewInPortCreateRequestDto;
import com.promptoven.reviewService.application.port.in.dto.ReviewInPortDto;
import com.promptoven.reviewService.application.port.in.dto.ReviewInPortUpdateRequestDto;
import com.promptoven.reviewService.application.port.out.dto.ReviewOutPortDto;
import com.promptoven.reviewService.application.port.out.dto.ReviewQueryDto;
import com.promptoven.reviewService.domain.model.Review;
import org.springframework.stereotype.Service;

@Service
public class ReviewDomainService {

    public Review createReview(ReviewInPortCreateRequestDto reviewCreateRequestDto) {
        return Review.builder()
                .productUuid(reviewCreateRequestDto.getProductUuid())
                .authorUuid(reviewCreateRequestDto.getAuthorUuid())
                .star(reviewCreateRequestDto.getStar())
                .contents(reviewCreateRequestDto.getContents())
                .isDeleted(false)
                .build();
    }

    public Review updateReview(ReviewQueryDto reviewQueryDto, ReviewInPortUpdateRequestDto reviewInPortDto) {
        return Review.builder()
                .id(reviewQueryDto.getId())
                .productUuid(reviewQueryDto.getProductUuid())
                .authorUuid(reviewQueryDto.getAuthorUuid())
                .star(reviewInPortDto.getStar())
                .contents(reviewInPortDto.getContents())
                .isDeleted(reviewQueryDto.getIsDeleted())
                .build();
    }

    public Review deleteReview(ReviewQueryDto reviewQueryDto) {
        return Review.builder()
                .id(reviewQueryDto.getId())
                .productUuid(reviewQueryDto.getProductUuid())
                .authorUuid(reviewQueryDto.getAuthorUuid())
                .star(reviewQueryDto.getStar())
                .contents(reviewQueryDto.getContents())
                .isDeleted(true)
                .build();
    }

}
