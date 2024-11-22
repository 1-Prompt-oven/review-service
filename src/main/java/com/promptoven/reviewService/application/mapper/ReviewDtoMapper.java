package com.promptoven.reviewService.application.mapper;

import com.promptoven.reviewService.application.port.in.dto.ReviewInPortCreateRequestDto;
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
                .authorUuid(reviewQueryDto.getAuthorUuid())
                .authorProfileImage(createRequestDto.getAuthorProfileImage())
                .authorNickname(createRequestDto.getAuthorNickname())
                .star(reviewQueryDto.getStar())
                .contents(reviewQueryDto.getContents())
                .isDeleted(reviewQueryDto.getIsDeleted())
                .build();
    }

    public UpdateEventMessageDto toUpdateMessageDto(ReviewPersistenceDto reviewPersistenceDto,
            ReviewQueryDto reviewQueryDto) {
        return UpdateEventMessageDto.builder()
                .reviewId(reviewQueryDto.getId())
                .productUuid(reviewQueryDto.getProductUuid())
                .contents(reviewPersistenceDto.getContents())
                .star(reviewPersistenceDto.getStar())
                .previousStar(reviewQueryDto.getStar())
                .build();
    }

    public DeleteEventMessageDto toDeleteMessageDto(ReviewQueryDto reviewQueryDto) {
        return DeleteEventMessageDto.builder()
                .reviewId(reviewQueryDto.getId())
                .productUuid(reviewQueryDto.getProductUuid())
                .star(reviewQueryDto.getStar())
                .build();
    }
}
