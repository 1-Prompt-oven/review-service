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

        ReviewPersistenceDto reviewPersistenceDto = reviewDtoMapper.toPersistenceDto(reviewDomainService.createReview(reviewCreateRequestDto));

        reviewRepositoryPort.save(reviewPersistenceDto);
        // TODO 카프카 DTO 리팩토링 -> MessageDTO 명시적으로 변경
//        messagePort.createReviewMessage(reviewRepositoryPort.save(reviewOutPortDto));
    }

    @Override
    public void updateReview(ReviewInPortUpdateRequestDto reviewInPortDto) {

        // DB에서 가져오는 데이터를 QueryDto 라고 명명
        ReviewQueryDto reviewQueryDto = reviewRepositoryPort.getReviewByReviewId(
                reviewInPortDto.getReviewId()).orElseThrow(() -> new BaseException(NO_EXIST_REVIEW));

        ReviewPersistenceDto reviewPersistenceDto = reviewDtoMapper.toPersistenceDto(reviewDomainService.updateReview(reviewQueryDto, reviewInPortDto));

        reviewRepositoryPort.update(reviewPersistenceDto);

        // TODO 카프카 DTO 리팩토링
//        MessageOutDto messageOutDto = reviewDtoMapper.toUpdateMessageDto(reviewOutPortDtoUpdated, reviewOutPortDto.getStar());
//
//        messagePort.updateReviewMessage(messageOutDto);
    }

    @Override
    public void deleteReview(Long reviewId) {

        ReviewQueryDto reviewQueryDto = reviewRepositoryPort.getReviewByReviewId(reviewId).orElseThrow(
                () -> new BaseException(NO_EXIST_REVIEW));

        ReviewPersistenceDto reviewPersistenceDto = reviewDtoMapper.toPersistenceDto(reviewDomainService.deleteReview(reviewQueryDto));

        reviewRepositoryPort.delete(reviewPersistenceDto);

//        ReviewOutPortDto savedReviewData = reviewRepositoryPort.delete(reviewOutPortDtoUpdated);
        // TODO 카프카 DTO 리팩토링
//        MessageOutDto messageOutDto = reviewDtoMapper.toMessageDto(savedReviewData.getId(), reviewOutPortDtoUpdated);
//
//        messagePort.deleteReviewMessage(messageOutDto);
    }

}
