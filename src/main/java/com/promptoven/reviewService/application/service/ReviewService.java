package com.promptoven.reviewService.application.service;

import static com.promptoven.reviewService.global.common.response.BaseResponseStatus.NO_EXIST_REVIEW;

import com.promptoven.reviewService.application.mapper.ReviewDtoMapper;
import com.promptoven.reviewService.application.port.in.ReviewInPortDto;
import com.promptoven.reviewService.application.port.in.ReviewInPaginationDto;
import com.promptoven.reviewService.application.port.in.ReviewUseCase;
import com.promptoven.reviewService.application.port.out.ReviewOutPaginationDto;
import com.promptoven.reviewService.application.port.out.ReviewOutPortDto;
import com.promptoven.reviewService.application.port.out.ReviewRepositoryPort;
import com.promptoven.reviewService.domain.model.Review;
import com.promptoven.reviewService.domain.service.ReviewDomainService;
import com.promptoven.reviewService.global.common.utils.CursorPage;
import com.promptoven.reviewService.global.error.BaseException;
import java.time.LocalDateTime;
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

    @Override
    public void createReview(ReviewInPortDto reviewInPortDto) {

        Review review = reviewDomainService.createReview(reviewInPortDto);
        ReviewOutPortDto reviewOutPortDto = reviewDtoMapper.toDto(review);

        reviewRepositoryPort.save(reviewOutPortDto);
    }

    @Override
    public void updateReview(ReviewInPortDto reviewInPortDto) {

        ReviewOutPortDto reviewOutPortDto = reviewRepositoryPort.getReviewByReviewId(
                reviewInPortDto.getId()).orElseThrow(() -> new BaseException(NO_EXIST_REVIEW));

        Review review = reviewDomainService.updateReview(reviewOutPortDto, reviewInPortDto);
        ReviewOutPortDto reviewOutPortDtoUpdated = reviewDtoMapper.toDto(review);

        reviewRepositoryPort.update(reviewOutPortDtoUpdated);
    }

    @Override
    public void deleteReview(Long reviewId) {

        ReviewOutPortDto reviewTransactionDto = reviewRepositoryPort.getReviewByReviewId(reviewId).orElseThrow(
                () -> new BaseException(NO_EXIST_REVIEW));

        Review review = reviewDomainService.deleteReview(reviewTransactionDto);
        ReviewOutPortDto reviewOutPortDtoUpdated = reviewDtoMapper.toDto(review);

        reviewRepositoryPort.delete(reviewOutPortDtoUpdated);
    }

    @Override
    public ReviewInPaginationDto getReview(ReviewInPaginationDto reviewInPaginationDto) {

        ReviewOutPaginationDto reviewOutPortDtoCursorPage = reviewRepositoryPort.getReviewByProductUuid(
                reviewInPaginationDto);

        List<Review> reviewList = reviewDomainService.getReview(reviewOutPortDtoCursorPage.getReviewOutPortDtoList());
        List<ReviewInPortDto> reviewInPortDtoList = reviewDtoMapper.toDtoList(reviewList);

        log.info("reviewOutPortDtoCursorPage: {}", reviewOutPortDtoCursorPage);

        Boolean hasNext = reviewOutPortDtoCursorPage.getHasNext();
        Long lastId = reviewOutPortDtoCursorPage.getLastId();
        LocalDateTime lastCreatedAt = reviewOutPortDtoCursorPage.getLastCreatedAt();
        Integer pageSize = reviewOutPortDtoCursorPage.getPageSize();
        Integer page = reviewOutPortDtoCursorPage.getPage();

        return reviewDtoMapper.toPaginationDto(reviewInPortDtoList, hasNext, lastId, lastCreatedAt, pageSize, page);
    }

//        return CursorPage.<ReviewInPortDto>builder()
//                .content(reviewInPortDtoList)
//                .lastId(reviewOutPortDtoCursorPage.getLastId())
//                .lastCreatedAt(reviewOutPortDtoCursorPage.getLastCreatedAt())
//                .hasNext(reviewOutPortDtoCursorPage.getHasNext())
//                .page(reviewOutPortDtoCursorPage.getPage())
//                .pageSize(reviewOutPortDtoCursorPage.getPageSize())
//                .build();

// body -> 숨겨야 하는 값
    // pathvariable 필수
    // requestparam 선택
    // requestbody 그외
    // url rest 원칙
}
