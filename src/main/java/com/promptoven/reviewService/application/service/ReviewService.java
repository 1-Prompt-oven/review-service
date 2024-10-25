package com.promptoven.reviewService.application.service;

import static com.promptoven.reviewService.global.common.response.BaseResponseStatus.NO_EXIST_REVIEW;

import com.promptoven.reviewService.application.mapper.ReviewDtoMapper;
import com.promptoven.reviewService.application.port.in.ReviewInPortDto;
import com.promptoven.reviewService.application.port.in.ReviewUseCase;
import com.promptoven.reviewService.application.port.out.ReviewRepositoryPort;
import com.promptoven.reviewService.application.port.out.ReviewOutPortDto;
import com.promptoven.reviewService.domain.service.ReviewDomainService;
import com.promptoven.reviewService.global.error.BaseException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService implements ReviewUseCase {

    private final ReviewRepositoryPort reviewRepositoryPort;
    private final ReviewDomainService reviewDomainService;
    private final ReviewDtoMapper reviewDtoMapper;

    @Override
    public void createReview(ReviewInPortDto reviewInPortDto) {
        reviewRepositoryPort.save(reviewDtoMapper.toDto(reviewDomainService.createReview(reviewInPortDto)));
    }

    @Override
    public void updateReview(ReviewInPortDto reviewInPortDto) {
        Optional<ReviewOutPortDto> reviewTransactionDto = reviewRepositoryPort.getReviewByReviewId(
                reviewInPortDto.getId());

        if (reviewTransactionDto.isEmpty()) {
            throw new BaseException(NO_EXIST_REVIEW);
        }

        reviewRepositoryPort.update(
                reviewDtoMapper.toDto(reviewDomainService.updateReview(reviewTransactionDto.get(), reviewInPortDto)));
    }

    @Override
    public void deleteReview(Long reviewId) {
        Optional<ReviewOutPortDto> reviewTransactionDto = reviewRepositoryPort.getReviewByReviewId(reviewId);

        if (reviewTransactionDto.isEmpty()) {
            throw new BaseException(NO_EXIST_REVIEW);
        }

        reviewRepositoryPort.delete(
                reviewDtoMapper.toDto(reviewDomainService.deleteReview(reviewTransactionDto.get())));
    }

    @Override
    public List<ReviewInPortDto> getReview(String productUuid) {
        return reviewDtoMapper.toDtoList(
                reviewDomainService.getReview(reviewRepositoryPort.getReviewsByProductUuid(productUuid)));
    }

}
