package com.promptoven.reviewService.adaptor.in.web.controller;

import com.promptoven.reviewService.adaptor.in.web.mapper.ReviewVoMapper;
import com.promptoven.reviewService.adaptor.in.web.vo.ReviewRequestVo;
import com.promptoven.reviewService.adaptor.in.web.vo.ReviewResponseVo;
import com.promptoven.reviewService.adaptor.in.web.vo.ReviewUpdateRequestVo;
import com.promptoven.reviewService.application.port.in.ReviewInPaginationDto;
import com.promptoven.reviewService.application.port.in.ReviewInPortDto;
import com.promptoven.reviewService.application.port.in.ReviewUseCase;
import com.promptoven.reviewService.global.common.response.BaseResponse;
import com.promptoven.reviewService.global.common.utils.CursorPage;
import io.swagger.v3.oas.annotations.Operation;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public BaseResponse<Void> createReview(@RequestBody ReviewRequestVo reviewRequestVo) {

        ReviewInPortDto reviewInPortDto = reviewVoMapper.toDto(reviewRequestVo);
        reviewUseCase.createReview(reviewInPortDto);

        return new BaseResponse<>();
    }

    @Operation(summary = "리뷰 수정 API", tags = {"리뷰"})
    @PutMapping
    public BaseResponse<Void> updateReview(@RequestBody ReviewUpdateRequestVo reviewRequestVo) {

        ReviewInPortDto reviewInPortDto = reviewVoMapper.toUpdateDto(reviewRequestVo);
        reviewUseCase.updateReview(reviewInPortDto);

        return new BaseResponse<>();
    }

    @Operation(summary = "리뷰 삭제 API", tags = {"리뷰"})
    @DeleteMapping("/{reviewId}")
    public BaseResponse<Void> deleteReview(@PathVariable("reviewId") Long reviewId) {

        reviewUseCase.deleteReview(reviewId);

        return new BaseResponse<>();
    }

    @Operation(summary = "리뷰 조회 API", tags = {"리뷰"})
    @GetMapping
    public BaseResponse<CursorPage<ReviewResponseVo>> getReview(@RequestParam String productUuid,
            @RequestParam(required = false) LocalDateTime lastCreatedAt,
            @RequestParam(required = false) Long lastId, @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) Integer page) {

        ReviewInPaginationDto reviewInPaginationDto = reviewVoMapper.toPaginationDto(productUuid, lastCreatedAt, lastId,
                pageSize, page);

        ReviewInPaginationDto reviewResponsePaginationDto = reviewUseCase.getReview(reviewInPaginationDto);

        return new BaseResponse<>(reviewVoMapper.toCursorPage(reviewResponsePaginationDto));
    }
}
