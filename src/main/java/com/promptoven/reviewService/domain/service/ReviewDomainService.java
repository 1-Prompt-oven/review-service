package com.promptoven.reviewService.domain.service;

import com.promptoven.reviewService.application.port.in.ReviewRequestDto;
import com.promptoven.reviewService.application.port.out.ReviewOutPortDto;
import com.promptoven.reviewService.domain.model.Review;
import java.util.List;
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

    public Review updateReview(ReviewOutPortDto reviewOutPortDto, ReviewRequestDto reviewRequestDto) {
        return Review.builder()
                .id(reviewOutPortDto.getId())
                .productUuid(reviewOutPortDto.getProductUuid())
                .memberUuid(reviewOutPortDto.getMemberUuid())
                .star(reviewRequestDto.getStar())
                .contents(reviewRequestDto.getContents())
                .isDeleted(reviewRequestDto.getIsDeleted())
                .build();
    }

    public Review deleteReview(ReviewOutPortDto reviewOutPortDto) {
        return Review.builder()
                .id(reviewOutPortDto.getId())
                .productUuid(reviewOutPortDto.getProductUuid())
                .memberUuid(reviewOutPortDto.getMemberUuid())
                .star(reviewOutPortDto.getStar())
                .contents(reviewOutPortDto.getContents())
                .isDeleted(true)
                .build();
    }

    public List<Review> getReview(List<ReviewOutPortDto> reviewOutPortDtoList) {
        return reviewOutPortDtoList.stream().map(reviewOutPortDto -> Review.builder()
                .id(reviewOutPortDto.getId())
                .productUuid(reviewOutPortDto.getProductUuid())
                .memberUuid(reviewOutPortDto.getMemberUuid())
                .star(reviewOutPortDto.getStar())
                .contents(reviewOutPortDto.getContents())
                .isDeleted(reviewOutPortDto.getIsDeleted())
                .build()).toList();
    }
}
