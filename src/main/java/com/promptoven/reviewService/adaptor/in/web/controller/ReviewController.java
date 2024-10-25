package com.promptoven.reviewService.adaptor.in.web.controller;

import com.promptoven.reviewService.adaptor.in.web.mapper.ReviewVoMapper;
import com.promptoven.reviewService.adaptor.in.web.vo.ReviewRequestVo;
import com.promptoven.reviewService.adaptor.in.web.vo.ReviewResponseVo;
import com.promptoven.reviewService.adaptor.in.web.vo.ReviewUpdateRequestVo;
import com.promptoven.reviewService.application.port.in.ReviewRequestDto;
import com.promptoven.reviewService.application.port.in.ReviewUseCase;
import com.promptoven.reviewService.global.common.response.BaseResponse;
import com.promptoven.reviewService.global.common.response.BaseResponseStatus;
import io.swagger.v3.oas.annotations.Parameter;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewUseCase reviewUseCase;
    private final ReviewVoMapper reviewVoMapper;

    @PostMapping
    public BaseResponse<Void> createReview(@RequestBody ReviewRequestVo reviewRequestVo) {
        reviewUseCase.createReview(reviewVoMapper.toDto(reviewRequestVo));
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    @PutMapping
    public BaseResponse<Void> updateReview(@RequestBody ReviewUpdateRequestVo reviewRequestVo) {
        reviewUseCase.updateReview(reviewVoMapper.toUpdateDto(reviewRequestVo));
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    @DeleteMapping("/{reviewId}")
    public BaseResponse<Void> deleteReview(@PathVariable("reviewId") Long reviewId) {
        reviewUseCase.deleteReview(reviewId);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    @GetMapping("/{productUuid}")
    public BaseResponse<List<ReviewResponseVo>> getReview(@PathVariable("productUuid") String productUuid) {
        List<ReviewRequestDto> reviewRequestDtoList = reviewUseCase.getReview(productUuid);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS, reviewVoMapper.toVoList(reviewRequestDtoList));
    }
}
