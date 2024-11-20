package com.promptoven.reviewService.adaptor.out.mysql.mapper;

import com.promptoven.reviewService.adaptor.out.mysql.entity.ReviewEntity;
import com.promptoven.reviewService.application.port.out.ReviewOutPortDto;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class ReviewEntityMapper {

    public ReviewEntity toEntity(ReviewOutPortDto reviewOutPortDto) {
        return ReviewEntity.builder()
                .productUuid(reviewOutPortDto.getProductUuid())
                .authorUuid(reviewOutPortDto.getauthorUuid())
                .memberProfileImage(reviewOutPortDto.getMemberProfileImage())
                .memberNickname(reviewOutPortDto.getMemberNickname())
                .star(reviewOutPortDto.getStar())
                .contents(reviewOutPortDto.getContents())
                .isDeleted(reviewOutPortDto.getIsDeleted())
                .build();
    }

    public ReviewEntity toUpdateEntity(ReviewOutPortDto reviewOutPortDto) {
        return ReviewEntity.builder()
                .reviewId(reviewOutPortDto.getId())
                .productUuid(reviewOutPortDto.getProductUuid())
                .authorUuid(reviewOutPortDto.getauthorUuid())
                .memberProfileImage(reviewOutPortDto.getMemberProfileImage())
                .memberNickname(reviewOutPortDto.getMemberNickname())
                .star(reviewOutPortDto.getStar())
                .contents(reviewOutPortDto.getContents())
                .isDeleted(reviewOutPortDto.getIsDeleted())
                .build();
    }

    public ReviewEntity toDeleteEntity(ReviewOutPortDto reviewOutPortDto) {
        return ReviewEntity.builder()
                .reviewId(reviewOutPortDto.getId())
                .productUuid(reviewOutPortDto.getProductUuid())
                .authorUuid(reviewOutPortDto.getauthorUuid())
                .memberProfileImage(reviewOutPortDto.getMemberProfileImage())
                .memberNickname(reviewOutPortDto.getMemberNickname())
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

}
