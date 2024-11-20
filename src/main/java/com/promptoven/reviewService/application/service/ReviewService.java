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
    public void createReview(ReviewInPortCreateRequestDto reviewCreateRequestDto) {
        // 리뷰 도메인 데이터 -> DB 저장 데이터로 변환
        ReviewPersistenceDto reviewPersistenceDto = reviewDtoMapper.toPersistenceDto(
                reviewDomainService.createReview(reviewCreateRequestDto));

        // DB 저장 후 리턴 데이터 카프카 메시지로 전송
        messagePort.createReviewMessage(reviewRepositoryPort.save(reviewPersistenceDto));
    }

    @Override
    public void updateReview(ReviewInPortUpdateRequestDto reviewInPortDto) {

        ReviewQueryDto reviewQueryDto = reviewRepositoryPort.getReviewByReviewId(
                reviewInPortDto.getId()).orElseThrow(() -> new BaseException(NO_EXIST_REVIEW));

        // 리뷰 도메인 데이터 -> DB 저장 데이터로 변환
        ReviewPersistenceDto reviewPersistenceDto = reviewDtoMapper.toPersistenceDto(
                reviewDomainService.updateReview(reviewQueryDto, reviewInPortDto));

        ReviewPersistenceDto savedReviewData = reviewRepositoryPort.update(reviewPersistenceDto);

        // TODO 카프카 CDC 적용 예정
//         MessageOutDto messageOutDto = reviewDtoMapper.toUpdateMessageDto(reviewOutPortDtoUpdated, reviewOutPortDto.getStar());
//
//        messagePort.updateReviewMessage(messageOutDto);
    }

    @Override
    public void deleteReview(Long reviewId) {

        ReviewQueryDto reviewQueryDto = reviewRepositoryPort.getReviewByReviewId(reviewId).orElseThrow(
                () -> new BaseException(NO_EXIST_REVIEW));

        // 리뷰 도메인 데이터 -> DB 저장 데이터로 변환
        ReviewPersistenceDto reviewPersistenceDto = reviewDtoMapper.toPersistenceDto(
                reviewDomainService.deleteReview(reviewQueryDto));

        ReviewPersistenceDto savedReviewData = reviewRepositoryPort.delete(reviewPersistenceDto);

        // TODO 카프카 CDC 적용 예정
//        MessageOutDto messageOutDto = reviewDtoMapper.toMessageDto(savedReviewData.getId(), reviewOutPortDtoUpdated);
//
//        messagePort.deleteReviewMessage(messageOutDto);
    }

}
