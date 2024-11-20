package com.promptoven.reviewService.adaptor.mysql.mapper;

import com.promptoven.reviewService.adaptor.mysql.entity.ReviewEntity;
import com.promptoven.reviewService.application.port.out.dto.ReviewOutPortDto;
import com.promptoven.reviewService.application.port.out.dto.ReviewPersistenceDto;
import com.promptoven.reviewService.application.port.out.dto.ReviewQueryDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewEntityMapper {

    public ReviewEntity toEntity(ReviewPersistenceDto reviewOutPortDto) {
        return ReviewEntity.builder()
                .productUuid(reviewOutPortDto.getProductUuid())
                .authorUuid(reviewOutPortDto.getAuthorUuid())
                .star(reviewOutPortDto.getStar())
                .contents(reviewOutPortDto.getContents())
                .isDeleted(reviewOutPortDto.getIsDeleted())
                .build();
    }

    public ReviewEntity toUpdateEntity(ReviewPersistenceDto reviewOutPortDto) {
        return ReviewEntity.builder()
                .reviewId(reviewOutPortDto.getId())
                .productUuid(reviewOutPortDto.getProductUuid())
                .authorUuid(reviewOutPortDto.getAuthorUuid())
                .star(reviewOutPortDto.getStar())
                .contents(reviewOutPortDto.getContents())
                .isDeleted(reviewOutPortDto.getIsDeleted())
                .build();
    }

    public ReviewEntity toDeleteEntity(ReviewPersistenceDto reviewOutPortDto) {
        return ReviewEntity.builder()
                .reviewId(reviewOutPortDto.getId())
                .productUuid(reviewOutPortDto.getProductUuid())
                .authorUuid(reviewOutPortDto.getAuthorUuid())
                .star(reviewOutPortDto.getStar())
                .contents(reviewOutPortDto.getContents())
                .isDeleted(reviewOutPortDto.getIsDeleted())
                .build();
    }

    public ReviewOutPortDto toDto(ReviewEntity reviewEntity) {
        return ReviewOutPortDto.builder()
                .id(reviewEntity.getReviewId())
                .productUuid(reviewEntity.getProductUuid())
                .authorUuid(reviewEntity.getAuthorUuid())
                .star(reviewEntity.getStar())
                .contents(reviewEntity.getContents())
                .isDeleted(reviewEntity.getIsDeleted())
                .createdAt(reviewEntity.getCreatedAt())
                .updatedAt(reviewEntity.getUpdatedAt())
                .build();
    }

    public ReviewQueryDto toQueryDto(ReviewEntity reviewEntity) {
        return ReviewQueryDto.builder()
                .id(reviewEntity.getReviewId())
                .productUuid(reviewEntity.getProductUuid())
                .authorUuid(reviewEntity.getAuthorUuid())
                .star(reviewEntity.getStar())
                .contents(reviewEntity.getContents())
                .isDeleted(reviewEntity.getIsDeleted())
                .createdAt(reviewEntity.getCreatedAt())
                .updatedAt(reviewEntity.getUpdatedAt())
                .build();
    }

}
