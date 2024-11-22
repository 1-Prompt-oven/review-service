package com.promptoven.reviewService.adaptor.web.mapper;

import com.promptoven.reviewService.adaptor.web.vo.ReviewCreateRequestVo;
import com.promptoven.reviewService.adaptor.web.vo.ReviewUpdateRequestVo;
import com.promptoven.reviewService.application.port.in.dto.ReviewInPortCreateRequestDto;
import com.promptoven.reviewService.application.port.in.dto.ReviewInPortUpdateRequestDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewVoMapper {

    public ReviewInPortCreateRequestDto toCreateDto(ReviewCreateRequestVo reviewCreateRequestVo) {
        return ReviewInPortCreateRequestDto.builder()
                .productUuid(reviewCreateRequestVo.getProductUuid())
                .authorUuid(reviewCreateRequestVo.getAuthorUuid())
                .authorProfileImage(reviewCreateRequestVo.getAuthorProfileImage())
                .authorNickname(reviewCreateRequestVo.getAuthorNickname())
                .contents(reviewCreateRequestVo.getContents())
                .star(reviewCreateRequestVo.getStar())
                .build();
    }

    public ReviewInPortUpdateRequestDto toUpdateDto(ReviewUpdateRequestVo reviewUpdateRequestVo) {
        return ReviewInPortUpdateRequestDto.builder()
                .id(reviewUpdateRequestVo.getId())
                .contents(reviewUpdateRequestVo.getContents())
                .star(reviewUpdateRequestVo.getStar())
                .build();
    }

}
