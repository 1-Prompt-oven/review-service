package com.promptoven.reviewService.adaptor.mysql.mapper;

import com.promptoven.reviewService.adaptor.mysql.entity.ReviewEntity;
import com.promptoven.reviewService.application.port.out.dto.ReviewPersistenceDto;
import com.promptoven.reviewService.application.port.out.dto.ReviewQueryDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewEntityMapper {

    public ReviewEntity toCreateEntity(ReviewPersistenceDto reviewPersistenceDto) {
        return ReviewEntity.builder()
                .productUuid(reviewPersistenceDto.getProductUuid())
                .authorUuid(reviewPersistenceDto.getAuthorUuid())
                .star(reviewPersistenceDto.getStar())
                .contents(reviewPersistenceDto.getContents())
                .isDeleted(reviewPersistenceDto.getIsDeleted())
                .build();
    }

    public ReviewEntity toUpdateEntity(ReviewPersistenceDto reviewPersistenceDto) {
        return ReviewEntity.builder()
                .id(reviewPersistenceDto.getId())
                .productUuid(reviewPersistenceDto.getProductUuid())
                .authorUuid(reviewPersistenceDto.getAuthorUuid())
                .star(reviewPersistenceDto.getStar())
                .contents(reviewPersistenceDto.getContents())
                .isDeleted(reviewPersistenceDto.getIsDeleted())
                .build();
    }

    public ReviewPersistenceDto toPersistenceDto(ReviewEntity reviewEntity) {
        return ReviewPersistenceDto.builder()
                .id(reviewEntity.getId())
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
                .id(reviewEntity.getId())
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
