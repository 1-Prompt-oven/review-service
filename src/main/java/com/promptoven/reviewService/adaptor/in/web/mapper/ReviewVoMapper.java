package com.promptoven.reviewService.adaptor.in.web.mapper;

import com.promptoven.reviewService.adaptor.in.web.vo.ReviewRequestVo;
import com.promptoven.reviewService.adaptor.in.web.vo.ReviewResponseVo;
import com.promptoven.reviewService.adaptor.in.web.vo.ReviewUpdateRequestVo;
import com.promptoven.reviewService.application.port.in.ReviewRequestDto;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ReviewVoMapper {
    public ReviewRequestDto toDto(ReviewRequestVo reviewRequestVo) {
        return ReviewRequestDto.builder()
                .productUuid(reviewRequestVo.getProductUuid())
                .memberUuid(reviewRequestVo.getMemberUuid())
                .star(reviewRequestVo.getStar())
                .contents(reviewRequestVo.getContents())
                .build();
    }

    public ReviewRequestDto toUpdateDto(ReviewUpdateRequestVo reviewUpdateRequestVo) {
        return ReviewRequestDto.builder()
                .id(reviewUpdateRequestVo.getReviewId())
                .productUuid(reviewUpdateRequestVo.getProductUuid())
                .star(reviewUpdateRequestVo.getStar())
                .contents(reviewUpdateRequestVo.getContents())
                .build();
    }

    public List<ReviewResponseVo> toVoList(List<ReviewRequestDto> reviewRequestDtoList) {
        return reviewRequestDtoList.stream().map(reviewRequestDto -> ReviewResponseVo.builder()
                .id(reviewRequestDto.getId())
                .productUuid(reviewRequestDto.getProductUuid())
                .memberUuid(reviewRequestDto.getMemberUuid())
                .star(reviewRequestDto.getStar())
                .content(reviewRequestDto.getContents())
                .build()).toList();
    }
}
