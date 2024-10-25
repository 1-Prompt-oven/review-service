package com.promptoven.reviewService.domain.service;

import com.promptoven.reviewService.application.port.in.ReviewInPortDto;
import com.promptoven.reviewService.application.port.out.ReviewOutPortDto;
import com.promptoven.reviewService.domain.model.Review;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReviewDomainService {

    public Review createReview(ReviewInPortDto reviewInPortDto) {
        return Review.builder()
                .productUuid(reviewInPortDto.getProductUuid())
                .memberUuid(reviewInPortDto.getMemberUuid())
                .star(reviewInPortDto.getStar())
                .contents(reviewInPortDto.getContents())
                .isDeleted(false)
                .build();
    }

    public Review updateReview(ReviewOutPortDto reviewOutPortDto, ReviewInPortDto reviewInPortDto) {
        return Review.builder()
                .id(reviewOutPortDto.getId())
                .productUuid(reviewOutPortDto.getProductUuid())
                .memberUuid(reviewOutPortDto.getMemberUuid())
                .star(reviewInPortDto.getStar())
                .contents(reviewInPortDto.getContents())
                .isDeleted(reviewOutPortDto.getIsDeleted())
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
                .build()).toList();
    }
}
