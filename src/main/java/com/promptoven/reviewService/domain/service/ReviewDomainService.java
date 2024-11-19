package com.promptoven.reviewService.domain.service;

import com.promptoven.reviewService.application.port.in.ReviewInPortDto;
import com.promptoven.reviewService.application.port.out.ReviewOutPortDto;
import com.promptoven.reviewService.domain.model.Review;
import org.springframework.stereotype.Service;

@Service
public class ReviewDomainService {

    public Review createReview(ReviewInPortDto reviewInPortDto) {
        return Review.builder()
                .productUuid(reviewInPortDto.getProductUuid())
                .memberUuid(reviewInPortDto.getMemberUuid())
                .memberProfileImage(reviewInPortDto.getMemberProfileImage())
                .memberNickname(reviewInPortDto.getMemberNickname())
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
                .memberProfileImage(
                        reviewInPortDto.getMemberProfileImage() != null ? reviewInPortDto.getMemberProfileImage()
                                : reviewOutPortDto.getMemberProfileImage())
                .memberNickname(reviewInPortDto.getMemberNickname() != null ? reviewInPortDto.getMemberNickname()
                        : reviewOutPortDto.getMemberNickname())
                .star(reviewInPortDto.getStar() != 0 ? reviewInPortDto.getStar() : reviewOutPortDto.getStar())
                .contents(reviewInPortDto.getContents() != null ? reviewInPortDto.getContents()
                        : reviewOutPortDto.getContents())
                .isDeleted(reviewOutPortDto.getIsDeleted())
                .build();
    }

    public Review deleteReview(ReviewOutPortDto reviewOutPortDto) {
        return Review.builder()
                .id(reviewOutPortDto.getId())
                .productUuid(reviewOutPortDto.getProductUuid())
                .memberUuid(reviewOutPortDto.getMemberUuid())
                .memberProfileImage(reviewOutPortDto.getMemberProfileImage())
                .memberNickname(reviewOutPortDto.getMemberNickname())
                .star(reviewOutPortDto.getStar())
                .contents(reviewOutPortDto.getContents())
                .isDeleted(true)
                .build();
    }

}
