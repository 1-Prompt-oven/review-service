package com.promptoven.reviewService.adaptor.out.mysql.mapper;

import com.promptoven.reviewService.adaptor.out.mysql.entity.ReviewEntity;
import com.promptoven.reviewService.application.port.out.ReviewTransactionDto;
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
}
