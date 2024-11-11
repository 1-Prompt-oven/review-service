package com.promptoven.reviewService.application.mapper;

import com.promptoven.reviewService.application.port.in.ReviewInPaginationDto;
import com.promptoven.reviewService.application.port.in.ReviewInPortDto;
import com.promptoven.reviewService.application.port.out.MessageOutDto;
import com.promptoven.reviewService.application.port.out.ReviewOutPortDto;
import com.promptoven.reviewService.domain.model.Review;
import java.time.LocalDateTime;
import java.util.List;
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

    public List<ReviewInPortDto> toDtoList(List<Review> reviewList) {
        return reviewList.stream().map(review -> ReviewInPortDto.builder()
                .id(review.getId())
                .productUuid(review.getProductUuid())
                .memberUuid(review.getMemberUuid())
                .star(review.getStar())
                .contents(review.getContents())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build()).toList();
    }

    public ReviewInPaginationDto toPaginationDto(List<ReviewInPortDto> reviewInPortDtoList,
            Boolean hasNext, Long lastId, LocalDateTime lastCreatedAt, Integer pageSize, Integer page) {
        return ReviewInPaginationDto.builder()
                .reviewInPortDtoList(reviewInPortDtoList)
                .hasNext(hasNext)
                .lastId(lastId)
                .lastCreatedAt(lastCreatedAt)
                .pageSize(pageSize)
                .page(page)
                .build();
    }

    public MessageOutDto toMessageDto(ReviewOutPortDto reviewOutPortDto) {
        return MessageOutDto.builder()
                .productUuid(reviewOutPortDto.getProductUuid())
                .star(reviewOutPortDto.getStar())
                .build();
    }

    public MessageOutDto toUpdateMessageDto(ReviewOutPortDto reviewOutPortDto, int previousStar) {
        return MessageOutDto.builder()
                .productUuid(reviewOutPortDto.getProductUuid())
                .star(reviewOutPortDto.getStar())
                .previousStar(previousStar)
                .build();
    }

}
