package com.promptoven.reviewService.adaptor.web.controller;

import com.promptoven.reviewService.adaptor.web.mapper.ReviewVoMapper;
import com.promptoven.reviewService.adaptor.web.vo.ReviewCreateRequestVo;
import com.promptoven.reviewService.adaptor.web.vo.ReviewUpdateRequestVo;
import com.promptoven.reviewService.application.port.in.usecase.ReviewUseCase;
import com.promptoven.reviewService.global.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/member/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewUseCase reviewUseCase;
    private final ReviewVoMapper reviewVoMapper;

    @Operation(summary = "리뷰 작성 API", tags = {"리뷰"})
    @PostMapping
    public BaseResponse<Void> createReview(@RequestBody ReviewCreateRequestVo reviewCreateRequestVo) {

        reviewUseCase.createReview(reviewVoMapper.toCreateDto(reviewCreateRequestVo));

        return new BaseResponse<>();
    }

    @Operation(summary = "리뷰 수정 API", tags = {"리뷰"})
    @PutMapping
    public BaseResponse<Void> updateReview(@RequestBody ReviewUpdateRequestVo reviewUpdateRequestVo) {

        reviewUseCase.updateReview(reviewVoMapper.toUpdateDto(reviewUpdateRequestVo));

        return new BaseResponse<>();
    }

    @Operation(summary = "리뷰 삭제 API", tags = {"리뷰"})
    @DeleteMapping("/{reviewId}")
    public BaseResponse<Void> deleteReview(@PathVariable("reviewId") Long reviewId) {

        reviewUseCase.deleteReview(reviewId);

        return new BaseResponse<>();
    }
}
