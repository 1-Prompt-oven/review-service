package com.promptoven.reviewService.application.service;

import com.promptoven.reviewService.adaptor.out.mysql.repository.ReviewJpaRepository;
import com.promptoven.reviewService.application.mapper.ReviewDtoMapper;
import com.promptoven.reviewService.application.port.in.ReviewRequestDto;
import com.promptoven.reviewService.application.port.in.ReviewUseCase;
import com.promptoven.reviewService.application.port.out.ReviewRepositoryPort;
import com.promptoven.reviewService.application.port.out.ReviewTransactionDto;
import com.promptoven.reviewService.domain.model.Review;
import com.promptoven.reviewService.domain.service.ReviewDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        ReviewTransactionDto reviewTransactionDto = reviewRepositoryPort.getReviewByReviewId(reviewRequestDto.getId());

        Review review = reviewDomainService.updateReview(reviewTransactionDto, reviewRequestDto);

        reviewRepositoryPort.update(reviewDtoMapper.toDto(review));
    }

    @Override
    public void deleteReview(Long reviewId) {
        ReviewTransactionDto reviewTransactionDto = reviewRepositoryPort.getReviewByReviewId(reviewId);
        Review review = reviewDomainService.deleteReview(reviewTransactionDto);
        reviewRepositoryPort.delete(reviewDtoMapper.toDto(review));
    }

}
