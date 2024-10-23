package com.promptoven.reviewService.adaptor.in.web.controller;

import com.promptoven.reviewService.adaptor.in.web.mapper.ReviewVoMapper;
import com.promptoven.reviewService.adaptor.in.web.vo.ReviewRequestVo;
import com.promptoven.reviewService.adaptor.in.web.vo.ReviewUpdateRequestVo;
import com.promptoven.reviewService.application.port.in.ReviewUseCase;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public ResponseEntity<Void> createReview(@RequestBody ReviewRequestVo reviewRequestVo) {
        reviewUseCase.createReview(reviewVoMapper.toDto(reviewRequestVo));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> updateReview(@RequestBody ReviewUpdateRequestVo reviewRequestVo) {
        reviewUseCase.updateReview(reviewVoMapper.toUpdateDto(reviewRequestVo));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable("reviewId") String reviewId) {
        reviewUseCase.deleteReview(reviewId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
