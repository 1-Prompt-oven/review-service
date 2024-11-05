package com.promptoven.reviewService.adaptor.out.mysql.mapper;

import com.promptoven.reviewService.adaptor.out.mysql.entity.AggregateEntity;
import com.promptoven.reviewService.adaptor.out.mysql.entity.ReviewEntity;
import com.promptoven.reviewService.application.port.out.AggregateDto;
import com.promptoven.reviewService.application.port.out.ReviewOutPortDto;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class ReviewEntityMapper {

    public ReviewEntity toEntity(ReviewOutPortDto reviewOutPortDto) {
        return ReviewEntity.builder()
                .productUuid(reviewOutPortDto.getProductUuid())
                .memberUuid(reviewOutPortDto.getMemberUuid())
                .star(reviewOutPortDto.getStar())
                .contents(reviewOutPortDto.getContents())
                .isDeleted(reviewOutPortDto.getIsDeleted())
                .build();
    }

    public ReviewEntity toUpdateEntity(ReviewOutPortDto reviewOutPortDto) {
        return ReviewEntity.builder()
                .reviewId(reviewOutPortDto.getId())
                .productUuid(reviewOutPortDto.getProductUuid())
                .memberUuid(reviewOutPortDto.getMemberUuid())
                .star(reviewOutPortDto.getStar())
                .contents(reviewOutPortDto.getContents())
                .isDeleted(reviewOutPortDto.getIsDeleted())
                .build();
    }

    public ReviewEntity toDeleteEntity(ReviewOutPortDto reviewOutPortDto) {
        return ReviewEntity.builder()
                .reviewId(reviewOutPortDto.getId())
                .productUuid(reviewOutPortDto.getProductUuid())
                .memberUuid(reviewOutPortDto.getMemberUuid())
                .star(reviewOutPortDto.getStar())
                .contents(reviewOutPortDto.getContents())
                .isDeleted(reviewOutPortDto.getIsDeleted())
                .build();
    }

    public ReviewOutPortDto toDto(ReviewEntity reviewEntity) {
        return ReviewOutPortDto.builder()
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

    public Optional<ReviewOutPortDto> toDto(Optional<ReviewEntity> reviewEntity) {
        return reviewEntity.map(this::toDto);
    }

}
