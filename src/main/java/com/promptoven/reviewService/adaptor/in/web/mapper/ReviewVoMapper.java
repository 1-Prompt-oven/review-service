package com.promptoven.reviewService.adaptor.in.web.mapper;

import com.promptoven.reviewService.adaptor.in.web.vo.ReviewGetRequestVo;
import com.promptoven.reviewService.adaptor.in.web.vo.ReviewRequestVo;
import com.promptoven.reviewService.adaptor.in.web.vo.ReviewResponseVo;
import com.promptoven.reviewService.adaptor.in.web.vo.ReviewUpdateRequestVo;
import com.promptoven.reviewService.application.port.in.ReviewInPortDto;
import com.promptoven.reviewService.application.port.in.ReviewPaginationDto;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ReviewVoMapper {

    public ReviewInPortDto toDto(ReviewRequestVo reviewRequestVo) {
        return ReviewInPortDto.builder()
                .productUuid(reviewRequestVo.getProductUuid())
                .memberUuid(reviewRequestVo.getMemberUuid())
                .star(reviewRequestVo.getStar())
                .contents(reviewRequestVo.getContents())
                .build();
    }

    public ReviewInPortDto toUpdateDto(ReviewUpdateRequestVo reviewUpdateRequestVo) {
        return ReviewInPortDto.builder()
                .id(reviewUpdateRequestVo.getReviewId())
                .star(reviewUpdateRequestVo.getStar())
                .contents(reviewUpdateRequestVo.getContents())
                .build();
    }

    public List<ReviewResponseVo> toVoList(List<ReviewInPortDto> reviewInPortDtoList) {
        return reviewInPortDtoList.stream().map(reviewRequestDto -> ReviewResponseVo.builder()
                .id(reviewRequestDto.getId())
                .productUuid(reviewRequestDto.getProductUuid())
                .memberUuid(reviewRequestDto.getMemberUuid())
                .star(reviewRequestDto.getStar())
                .content(reviewRequestDto.getContents())
                .createdAt(reviewRequestDto.getCreatedAt())
                .updatedAt(reviewRequestDto.getUpdatedAt())
                .build()).toList();
    }

    public ReviewPaginationDto toPaginationDto(ReviewGetRequestVo reviewGetRequestVo) {
        return ReviewPaginationDto.builder()
                .productUuid(reviewGetRequestVo.getProductUuid())
                .lastCreatedAt(reviewGetRequestVo.getLastCreatedAt())
                .lastId(reviewGetRequestVo.getLastId())
                .pageSize(reviewGetRequestVo.getPageSize())
                .page(reviewGetRequestVo.getPage())
                .build();
    }
}
