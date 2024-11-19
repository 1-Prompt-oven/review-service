package com.promptoven.reviewService.adaptor.in.web.mapper;

import com.promptoven.reviewService.adaptor.in.web.vo.ReviewRequestVo;
import com.promptoven.reviewService.adaptor.in.web.vo.ReviewUpdateRequestVo;
import com.promptoven.reviewService.application.port.in.ReviewInPortDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewVoMapper {

    public ReviewInPortDto toInPortDtoDto(ReviewRequestVo reviewRequestVo) {
        return ReviewInPortDto.builder()
                .productUuid(reviewRequestVo.getProductUuid())
                .memberUuid(reviewRequestVo.getMemberUuid())
                .memberProfileImage(reviewRequestVo.getMemberProfileImage())
                .memberNickname(reviewRequestVo.getMemberNickname())
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

}
