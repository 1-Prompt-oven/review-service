package com.promptoven.reviewService.application.mapper;

import com.promptoven.reviewService.application.port.in.dto.ReviewInPortCreateRequestDto;
import com.promptoven.reviewService.application.port.in.dto.ReviewInPortUpdateRequestDto;
import com.promptoven.reviewService.application.port.out.dto.Message.CreateEventMessageDto;
import com.promptoven.reviewService.application.port.out.dto.Message.DeleteEventMessageDto;
import com.promptoven.reviewService.application.port.out.dto.Message.UpdateEventMessageDto;
import com.promptoven.reviewService.application.port.out.dto.ReviewPersistenceDto;
import com.promptoven.reviewService.application.port.out.dto.ReviewQueryDto;
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

    public CreateEventMessageDto toCreateMessageDto(ReviewInPortCreateRequestDto createRequestDto,
            ReviewQueryDto reviewQueryDto) {
        return CreateEventMessageDto.builder()
                .reviewId(reviewQueryDto.getId())
                .productUuid(reviewQueryDto.getProductUuid())
                .purchaseProductId(createRequestDto.getPurchaseProductId())
                .authorUuid(reviewQueryDto.getAuthorUuid())
                .authorProfileImage(createRequestDto.getAuthorProfileImage())
                .authorNickname(createRequestDto.getAuthorNickname())
                .star(reviewQueryDto.getStar())
                .contents(reviewQueryDto.getContents())
                .isDeleted(reviewQueryDto.getIsDeleted())
                .build();
    }

    public UpdateEventMessageDto toUpdateMessageDto(ReviewQueryDto updatedReviewData,
            ReviewQueryDto savedReviewData) {
        return UpdateEventMessageDto.builder()
                .reviewId(savedReviewData.getId())
                .productUuid(savedReviewData.getProductUuid())
                .contents(updatedReviewData.getContents())
                .star(updatedReviewData.getStar())
                .previousStar(savedReviewData.getStar())
                .build();
    }

    public DeleteEventMessageDto toDeleteMessageDto(ReviewQueryDto reviewQueryDto, Long purchaseProductId) {
        return DeleteEventMessageDto.builder()
                .reviewId(reviewQueryDto.getId())
                .purchaseProductId(purchaseProductId)
                .productUuid(reviewQueryDto.getProductUuid())
                .star(reviewQueryDto.getStar())
                .build();
    }
}
