package com.promptoven.reviewService.application.service;

import static com.promptoven.reviewService.global.common.response.BaseResponseStatus.NO_EXIST_REVIEW;

import com.promptoven.reviewService.application.mapper.ReviewDtoMapper;
import com.promptoven.reviewService.application.port.in.dto.ReviewInPortCreateRequestDto;
import com.promptoven.reviewService.application.port.in.dto.ReviewInPortUpdateRequestDto;
import com.promptoven.reviewService.application.port.in.usecase.ReviewUseCase;
import com.promptoven.reviewService.application.port.out.call.MessagePort;
import com.promptoven.reviewService.application.port.out.call.ReviewRepositoryPort;
import com.promptoven.reviewService.application.port.out.dto.ReviewPersistenceDto;
import com.promptoven.reviewService.application.port.out.dto.ReviewQueryDto;
import com.promptoven.reviewService.domain.service.ReviewDomainService;
import com.promptoven.reviewService.global.error.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService implements ReviewUseCase {

    private final ReviewRepositoryPort reviewRepositoryPort;
    private final ReviewDomainService reviewDomainService;
    private final ReviewDtoMapper reviewDtoMapper;
    private final MessagePort messagePort;

    @Override
    public void createReview(ReviewInPortCreateRequestDto reviewCreateRequestDto) {

        ReviewPersistenceDto reviewPersistenceDto = reviewDtoMapper.toPersistenceDto(
                reviewDomainService.createReview(reviewCreateRequestDto));

        ReviewQueryDto savedReviewData = reviewRepositoryPort.save(reviewPersistenceDto);

        messagePort.createReviewMessage(reviewDtoMapper.toCreateMessageDto(reviewCreateRequestDto, savedReviewData));
    }

    @Override
    public void updateReview(ReviewInPortUpdateRequestDto reviewUpdateRequestDto) {

        ReviewQueryDto reviewQueryDto = reviewRepositoryPort.getReviewByReviewId(
                reviewUpdateRequestDto.getId()).orElseThrow(() -> new BaseException(NO_EXIST_REVIEW));

        ReviewPersistenceDto reviewPersistenceDto = reviewDtoMapper.toPersistenceDto(
                reviewDomainService.updateReview(reviewQueryDto, reviewUpdateRequestDto));

        ReviewQueryDto updatedReviewData = reviewRepositoryPort.update(reviewPersistenceDto);

        messagePort.updateReviewMessage(reviewDtoMapper.toUpdateMessageDto(reviewPersistenceDto, updatedReviewData));
    }

    @Override
    public void deleteReview(Long reviewId) {

        ReviewQueryDto reviewQueryDto = reviewRepositoryPort.getReviewByReviewId(reviewId).orElseThrow(
                () -> new BaseException(NO_EXIST_REVIEW));

        ReviewPersistenceDto reviewPersistenceDto = reviewDtoMapper.toPersistenceDto(
                reviewDomainService.deleteReview(reviewQueryDto));

        ReviewQueryDto deletedReviewData = reviewRepositoryPort.delete(reviewPersistenceDto);

        messagePort.deleteReviewMessage(reviewDtoMapper.toDeleteMessageDto(deletedReviewData));
    }
}
