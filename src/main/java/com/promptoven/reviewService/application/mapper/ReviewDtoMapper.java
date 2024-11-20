package com.promptoven.reviewService.application.mapper;

import com.promptoven.reviewService.application.port.in.dto.ReviewInPortDto;
import com.promptoven.reviewService.application.port.out.dto.MessageOutDto;
import com.promptoven.reviewService.application.port.out.dto.ReviewOutPortDto;
import com.promptoven.reviewService.application.port.out.dto.ReviewPersistenceDto;
import com.promptoven.reviewService.domain.model.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewDtoMapper {

    public ReviewPersistenceDto toPersistenceDto(Review review) {
        return ReviewPersistenceDto.builder()
                .id(review.getId())
                .productUuid(review.getProductUuid())
                .authorUuid(review.getAuthorUuid())
                .star(review.getStar())
                .contents(review.getContents())
                .isDeleted(review.getIsDeleted())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }

    public MessageOutDto toMessageDto(ReviewOutPortDto reviewOutPortDto) {
        return MessageOutDto.builder()
                .reviewId(reviewOutPortDto.getId())
                .productUuid(reviewOutPortDto.getProductUuid())
                .authorUuid(reviewOutPortDto.getAuthorUuid())
                .contents(reviewOutPortDto.getContents())
                .isDeleted(reviewOutPortDto.getIsDeleted())
                .star(reviewOutPortDto.getStar())
                .build();
    }

    public MessageOutDto toUpdateMessageDto(ReviewOutPortDto reviewOutPortDto, int previousStar) {
        return MessageOutDto.builder()
                .reviewId(reviewOutPortDto.getId())
                .productUuid(reviewOutPortDto.getProductUuid())
                .contents(reviewOutPortDto.getContents())
                .star(reviewOutPortDto.getStar())
                .previousStar(previousStar)
                .build();
    }

    public MessageOutDto toUpdateNicknameDto(ReviewInPortDto reviewInPortDto) {
        return MessageOutDto.builder()
                .authorUuid(reviewInPortDto.getAuthorUuid())
                .memberNickname(reviewInPortDto.getMemberNickname())
                .build();
    }

    public MessageOutDto toUpdateImageDto(ReviewInPortDto reviewInPortDto) {
        return MessageOutDto.builder()
                .authorUuid(reviewInPortDto.getAuthorUuid())
                .memberProfileImage(reviewInPortDto.getMemberProfileImage())
                .build();
    }
}
