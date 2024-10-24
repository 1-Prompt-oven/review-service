package com.promptoven.reviewService.adaptor.out.mysql.mapper;

import com.promptoven.reviewService.adaptor.out.mysql.entity.ReviewEntity;
import com.promptoven.reviewService.application.port.out.ReviewTransactionDto;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class ReviewEntityMapper {

    public ReviewEntity toEntity(ReviewTransactionDto reviewTransactionDto) {
        return ReviewEntity.builder()
                .productUuid(reviewTransactionDto.getProductUuid())
                .memberUuid(reviewTransactionDto.getMemberUuid())
                .star(reviewTransactionDto.getStar())
                .contents(reviewTransactionDto.getContents())
                .isDeleted(reviewTransactionDto.getIsDeleted())
                .build();
    }

    public ReviewEntity toUpdateEntity(ReviewTransactionDto reviewTransactionDto) {
        return ReviewEntity.builder()
                .reviewId(reviewTransactionDto.getId())
                .productUuid(reviewTransactionDto.getProductUuid())
                .memberUuid(reviewTransactionDto.getMemberUuid())
                .star(reviewTransactionDto.getStar())
                .contents(reviewTransactionDto.getContents())
                .isDeleted(reviewTransactionDto.getIsDeleted())
                .build();
    }

    public ReviewTransactionDto toDto(ReviewEntity reviewEntity) {
        return ReviewTransactionDto.builder()
                .id(reviewEntity.getReviewId())
                .productUuid(reviewEntity.getProductUuid())
                .memberUuid(reviewEntity.getMemberUuid())
                .star(reviewEntity.getStar())
                .contents(reviewEntity.getContents())
                .isDeleted(reviewEntity.getIsDeleted())
                .createdAt(reviewEntity.getCreatedAt())
                .updatedAt(reviewEntity.getUpdatedAt())
                .build();
    }

    public Optional<ReviewTransactionDto> toDto(Optional<ReviewEntity> reviewEntity) {
        return reviewEntity.map(this::toDto);
    }

}
