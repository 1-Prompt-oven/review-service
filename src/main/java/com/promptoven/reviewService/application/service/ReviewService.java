package com.promptoven.reviewService.application.service;

import static com.promptoven.reviewService.global.common.response.BaseResponseStatus.NO_EXIST_REVIEW;

import com.promptoven.reviewService.adaptor.out.mysql.entity.ReviewEntity;
import com.promptoven.reviewService.application.mapper.ReviewDtoMapper;
import com.promptoven.reviewService.application.port.in.ReviewInPortDto;
import com.promptoven.reviewService.application.port.in.ReviewUseCase;
import com.promptoven.reviewService.application.port.out.MessageOutDto;
import com.promptoven.reviewService.application.port.out.MessagePort;
import com.promptoven.reviewService.application.port.out.ReviewOutPortDto;
import com.promptoven.reviewService.application.port.out.ReviewRepositoryPort;
import com.promptoven.reviewService.domain.model.Review;
import com.promptoven.reviewService.domain.service.ReviewDomainService;
import com.promptoven.reviewService.global.error.BaseException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService implements ReviewUseCase {

    private final ReviewRepositoryPort reviewRepositoryPort;
    private final ReviewDomainService reviewDomainService;
    private final ReviewDtoMapper reviewDtoMapper;
    private final MessagePort messagePort;

    @Override
    public void createReview(ReviewInPortDto reviewInPortDto) {

        Review review = reviewDomainService.createReview(reviewInPortDto);

        ReviewOutPortDto reviewOutPortDto = reviewDtoMapper.toDto(review);

        ReviewEntity reviewEntity = reviewRepositoryPort.save(reviewOutPortDto);

        log.info("reviewEntity: {}", reviewEntity.getReviewId());

        MessageOutDto messageOutDto = reviewDtoMapper.toMessageDto(reviewEntity.getReviewId(), reviewOutPortDto);

        messagePort.createReviewMessage(messageOutDto);
    }

    @Override
    public void updateReview(ReviewInPortDto reviewInPortDto) {

        ReviewOutPortDto reviewOutPortDto = reviewRepositoryPort.getReviewByReviewId(
                reviewInPortDto.getId()).orElseThrow(() -> new BaseException(NO_EXIST_REVIEW));

        Review review = reviewDomainService.updateReview(reviewOutPortDto, reviewInPortDto);

        ReviewOutPortDto reviewOutPortDtoUpdated = reviewDtoMapper.toDto(review);

        ReviewEntity reviewEntity = reviewRepositoryPort.update(reviewOutPortDtoUpdated);

        MessageOutDto messageOutDto = reviewDtoMapper.toUpdateMessageDto(reviewEntity.getReviewId(),
                reviewOutPortDtoUpdated, reviewOutPortDto.getStar());

        messagePort.updateReviewMessage(messageOutDto);
    }

    @Override
    public void deleteReview(Long reviewId) {

        ReviewOutPortDto reviewTransactionDto = reviewRepositoryPort.getReviewByReviewId(reviewId).orElseThrow(
                () -> new BaseException(NO_EXIST_REVIEW));

        Review review = reviewDomainService.deleteReview(reviewTransactionDto);

        ReviewOutPortDto reviewOutPortDtoUpdated = reviewDtoMapper.toDto(review);

        ReviewEntity reviewEntity = reviewRepositoryPort.delete(reviewOutPortDtoUpdated);

        MessageOutDto messageOutDto = reviewDtoMapper.toMessageDto(reviewEntity.getReviewId(), reviewOutPortDtoUpdated);

        messagePort.deleteReviewMessage(messageOutDto);
    }
}
