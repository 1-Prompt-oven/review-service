package com.promptoven.reviewService.adaptor.in.web.mapper;

import com.promptoven.reviewService.adaptor.in.web.vo.ReviewRequestVo;
import com.promptoven.reviewService.application.port.in.ReviewRequestDto;
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
}
