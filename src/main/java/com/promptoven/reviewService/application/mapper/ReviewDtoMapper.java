package com.promptoven.reviewService.application.mapper;

import com.promptoven.reviewService.application.port.in.ReviewInPortDto;
import com.promptoven.reviewService.application.port.out.MessageOutDto;
import com.promptoven.reviewService.application.port.out.ReviewOutPortDto;
import com.promptoven.reviewService.domain.model.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewDtoMapper {

    public ReviewOutPortDto toOutPortDto(Review review) {
        return ReviewOutPortDto.builder()
                .id(review.getId())
                .productUuid(review.getProductUuid())
                .memberUuid(review.getMemberUuid())
                .memberProfileImage(review.getMemberProfileImage())
                .memberNickname(review.getMemberNickname())
                .star(review.getStar())
                .contents(review.getContents())
                .isDeleted(review.getIsDeleted())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }

    public MessageOutDto toMessageDto(Long reviewId, ReviewOutPortDto reviewOutPortDto) {
        return MessageOutDto.builder()
                .reviewId(reviewId)
                .productUuid(reviewOutPortDto.getProductUuid())
                .memberUuid(reviewOutPortDto.getMemberUuid())
                .memberProfileImage(reviewOutPortDto.getMemberProfileImage())
                .memberNickname(reviewOutPortDto.getMemberNickname())
                .contents(reviewOutPortDto.getContents())
                .isDeleted(reviewOutPortDto.getIsDeleted())
                .star(reviewOutPortDto.getStar())
                .build();
    }

    public MessageOutDto toUpdateMessageDto(Long reviewId, ReviewOutPortDto reviewOutPortDto, int previousStar) {
        return MessageOutDto.builder()
                .reviewId(reviewId)
                .productUuid(reviewOutPortDto.getProductUuid())
                .contents(reviewOutPortDto.getContents())
                .star(reviewOutPortDto.getStar())
                .previousStar(previousStar)
                .build();
    }

    public MessageOutDto toUpdateNicknameDto(ReviewInPortDto reviewInPortDto) {
        return MessageOutDto.builder()
                .memberUuid(reviewInPortDto.getMemberUuid())
                .memberNickname(reviewInPortDto.getMemberNickname())
                .build();
    }

    public MessageOutDto toUpdateImageDto(ReviewInPortDto reviewInPortDto) {
        return MessageOutDto.builder()
                .memberUuid(reviewInPortDto.getMemberUuid())
                .memberProfileImage(reviewInPortDto.getMemberProfileImage())
                .build();
    }
}
