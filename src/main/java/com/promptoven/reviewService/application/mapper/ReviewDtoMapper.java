package com.promptoven.reviewService.application.mapper;

import com.promptoven.reviewService.application.port.out.ReviewOutPortDto;
import com.promptoven.reviewService.domain.model.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewDtoMapper {

    public ReviewOutPortDto toDto(Review review) {
        return ReviewOutPortDto.builder()
                .id(review.getId())
                .productUuid(review.getProductUuid())
                .memberUuid(review.getMemberUuid())
                .star(review.getStar())
                .contents(review.getContents())
                .isDeleted(review.getIsDeleted())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }
}
