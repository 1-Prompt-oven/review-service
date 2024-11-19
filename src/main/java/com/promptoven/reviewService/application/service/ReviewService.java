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
import java.util.List;
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

        ReviewOutPortDto reviewOutPortDto = reviewDtoMapper.toOutPortDto(review);

        ReviewOutPortDto savedReviewData = reviewRepositoryPort.save(reviewOutPortDto);

        MessageOutDto messageOutDto = reviewDtoMapper.toMessageDto(savedReviewData.getId(), reviewOutPortDto);

        messagePort.createReviewMessage(messageOutDto);
    }

    @Override
    public void updateReview(ReviewInPortDto reviewInPortDto) {

        ReviewOutPortDto reviewOutPortDto = reviewRepositoryPort.getReviewByReviewId(
                reviewInPortDto.getId()).orElseThrow(() -> new BaseException(NO_EXIST_REVIEW));

        Review review = reviewDomainService.updateReview(reviewOutPortDto, reviewInPortDto);

        ReviewOutPortDto reviewOutPortDtoUpdated = reviewDtoMapper.toOutPortDto(review);

        ReviewOutPortDto savedReviewData = reviewRepositoryPort.update(reviewOutPortDtoUpdated);

        MessageOutDto messageOutDto = reviewDtoMapper.toUpdateMessageDto(savedReviewData.getId(),
                reviewOutPortDtoUpdated, reviewOutPortDto.getStar());

        messagePort.updateReviewMessage(messageOutDto);
    }

    @Override
    public void deleteReview(Long reviewId) {

        ReviewOutPortDto reviewTransactionDto = reviewRepositoryPort.getReviewByReviewId(reviewId).orElseThrow(
                () -> new BaseException(NO_EXIST_REVIEW));

        Review review = reviewDomainService.deleteReview(reviewTransactionDto);

        ReviewOutPortDto reviewOutPortDtoUpdated = reviewDtoMapper.toOutPortDto(review);

        ReviewOutPortDto savedReviewData = reviewRepositoryPort.delete(reviewOutPortDtoUpdated);

        MessageOutDto messageOutDto = reviewDtoMapper.toMessageDto(savedReviewData.getId(), reviewOutPortDtoUpdated);

        messagePort.deleteReviewMessage(messageOutDto);
    }

    @Override
    public void updateMemberData(ReviewInPortDto reviewInPortDto) {
        List<ReviewOutPortDto> reviewOutPortDtoList = reviewRepositoryPort.getReviewListByMemberUuid(reviewInPortDto.getMemberUuid());

        for (ReviewOutPortDto reviewOutPortDto : reviewOutPortDtoList) {

            Review updatedReview = reviewDomainService.updateReview(reviewOutPortDto, reviewInPortDto);

            ReviewOutPortDto updatedReviewOutPortDto = reviewDtoMapper.toOutPortDto(updatedReview);

            reviewRepositoryPort.update(updatedReviewOutPortDto);
        }

    }

}
