package com.promptoven.reviewService.adaptor.out.mysql.repository;

import com.promptoven.reviewService.adaptor.out.mysql.entity.QReviewEntity;
import com.promptoven.reviewService.adaptor.out.mysql.entity.ReviewEntity;
import com.promptoven.reviewService.adaptor.out.mysql.mapper.ReviewEntityMapper;
import com.promptoven.reviewService.application.port.in.ReviewInPaginationDto;
import com.promptoven.reviewService.application.port.out.ReviewOutPaginationDto;
import com.promptoven.reviewService.application.port.out.ReviewOutPortDto;
import com.promptoven.reviewService.application.port.out.ReviewRepositoryPort;
import com.promptoven.reviewService.global.common.utils.CursorPage;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryPort {

    private final ReviewJpaRepository reviewJpaRepository;
    private final ReviewEntityMapper reviewEntityMapper;
    private final JPAQueryFactory jpaQueryFactory;

    private static final int DEFAULT_PAGE_SIZE = 20;
    private static final int DEFAULT_PAGE_NUMBER = 0;

    @Override
    public void save(ReviewOutPortDto reviewOutPortDto) {
        ReviewEntity reviewEntity = reviewEntityMapper.toEntity(reviewOutPortDto);
        reviewJpaRepository.save(reviewEntity);
    }

    @Override
    public void update(ReviewOutPortDto reviewOutPortDto) {
        ReviewEntity reviewEntity = reviewEntityMapper.toUpdateEntity(reviewOutPortDto);
        reviewJpaRepository.save(reviewEntity);
    }

    @Override
    public Optional<ReviewOutPortDto> getReviewByReviewId(Long reviewId) {
        return reviewJpaRepository.findByReviewId(reviewId).map(reviewEntityMapper::toDto);
    }

    @Override
    public List<ReviewOutPortDto> getReviewsByProductUuid(String productUuid) {
        return reviewJpaRepository.findByProductUuidAndIsDeletedFalse(productUuid).stream()
                .map(reviewEntityMapper::toDto)
                .toList();
    }

    @Override
    public void delete(ReviewOutPortDto reviewOutPortDto) {
        ReviewEntity reviewEntity = reviewEntityMapper.toDeleteEntity(reviewOutPortDto);
        reviewJpaRepository.save(reviewEntity);
    }

    @Override
    public ReviewOutPaginationDto getReviewByProductUuid(ReviewInPaginationDto reviewInPaginationDto) {

        String productUuid = reviewInPaginationDto.getProductUuid();
        LocalDateTime lastCreatedAt = reviewInPaginationDto.getLastCreatedAt();
        Long lastId = reviewInPaginationDto.getLastId();
        Integer pageSize = reviewInPaginationDto.getPageSize();
        Integer page = reviewInPaginationDto.getPage();

        System.out.println("productUuid = " + productUuid);
        System.out.println("lastCreatedAt = " + lastCreatedAt);
        System.out.println("lastId = " + lastId);
        System.out.println("pageSize = " + pageSize);
        System.out.println("page = " + page);


        QReviewEntity reviewList = QReviewEntity.reviewEntity;
        BooleanBuilder builder = new BooleanBuilder();

        Optional.ofNullable(productUuid)
                .ifPresent(uuid -> builder.and(reviewList.productUuid.eq(uuid)));

        int currentPageSize = Optional.ofNullable(pageSize).orElse(DEFAULT_PAGE_SIZE);

        if (lastCreatedAt != null && lastId != null) {
            builder.and(
                    reviewList.createdAt.lt(lastCreatedAt)
                            .or(reviewList.createdAt.eq(lastCreatedAt).and(reviewList.reviewId.lt(lastId)))
            );
        }

        List<ReviewEntity> contents = jpaQueryFactory
                .select(reviewList)
                .from(reviewList)
                .where(builder)
                .orderBy(reviewList.createdAt.desc(), reviewList.reviewId.desc())
                .limit(currentPageSize + 1)
                .fetch();

        LocalDateTime nextCreatedAt = null;
        Long nextReviewId = null;
        boolean hasNext = false;

        if (contents.size() > currentPageSize) {
            hasNext = true;
            contents = contents.subList(0, currentPageSize);
            nextCreatedAt = contents.get(currentPageSize - 1).getCreatedAt();
            nextReviewId = contents.get(currentPageSize - 1).getReviewId();
        }

        List<ReviewOutPortDto> reviewOutPortDtoList = contents.stream()
                .map(reviewEntityMapper::toDto)
                .toList();

        return ReviewOutPaginationDto.builder()
                .reviewOutPortDtoList(reviewOutPortDtoList)
                .hasNext(hasNext)
                .lastCreatedAt(nextCreatedAt)
                .lastId(nextReviewId)
                .page(Optional.ofNullable(page).orElse(DEFAULT_PAGE_NUMBER))
                .pageSize(currentPageSize)
                .build();

//        return new CursorPage<>(reviewOutPortDtoList, nextReviewId, nextCreatedAt, hasNext, currentPageSize,
//                Optional.ofNullable(page).orElse(DEFAULT_PAGE_NUMBER));
    }
}

