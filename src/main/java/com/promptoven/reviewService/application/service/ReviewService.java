package com.promptoven.reviewService.application.service;

import static com.promptoven.reviewService.global.common.response.BaseResponseStatus.NO_EXIST_REVIEW;

import com.promptoven.reviewService.application.mapper.ReviewDtoMapper;
import com.promptoven.reviewService.application.port.in.ReviewRequestDto;
import com.promptoven.reviewService.application.port.in.ReviewUseCase;
import com.promptoven.reviewService.application.port.out.ReviewRepositoryPort;
import com.promptoven.reviewService.application.port.out.ReviewOutPortDto;
import com.promptoven.reviewService.domain.model.Review;
import com.promptoven.reviewService.domain.service.ReviewDomainService;
import com.promptoven.reviewService.global.error.BaseException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ReviewService implements ReviewUseCase {

    private final ReviewRepositoryPort reviewRepositoryPort;
    private final ReviewDomainService reviewDomainService;
    private final ReviewDtoMapper reviewDtoMapper;

    @Override
    public void createReview(ReviewRequestDto reviewRequestDto) {
        reviewRepositoryPort.save(reviewDtoMapper.toDto(reviewDomainService.createReview(reviewRequestDto)));
    }

    @Override
    public void updateReview(ReviewRequestDto reviewRequestDto) {
        Optional<ReviewOutPortDto> reviewTransactionDto = reviewRepositoryPort.getReviewByReviewId(
                reviewRequestDto.getId());

        if (reviewTransactionDto.isEmpty()) {
            throw new BaseException(NO_EXIST_REVIEW);
        }

        Review review = reviewDomainService.updateReview(reviewTransactionDto.get(), reviewRequestDto);

        reviewRepositoryPort.update(reviewDtoMapper.toDto(review));
    }

    @Override
    public void deleteReview(Long reviewId) {
        Optional<ReviewOutPortDto> reviewTransactionDto = reviewRepositoryPort.getReviewByReviewId(reviewId);

        if (reviewTransactionDto.isEmpty()) {
            throw new BaseException(NO_EXIST_REVIEW);
        }

        Review review = reviewDomainService.deleteReview(reviewTransactionDto.get());

        reviewRepositoryPort.delete(reviewDtoMapper.toDto(review));
    }

    @Override
    public List<ReviewRequestDto> getReview(String productUuid) {
        List<ReviewOutPortDto> reviewOutPortDtoList = reviewRepositoryPort.getReviewsByProductUuid(productUuid);

        List<Review> reviewList = reviewDomainService.getReview(reviewOutPortDtoList);

        return reviewDtoMapper.toDtoList(reviewList);
    }

}
