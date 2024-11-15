package com.promptoven.reviewService.adaptor.out.mysql.repository;

import com.promptoven.reviewService.adaptor.out.mysql.entity.ReviewEntity;
import com.promptoven.reviewService.adaptor.out.mysql.mapper.ReviewEntityMapper;
import com.promptoven.reviewService.application.port.out.ReviewOutPortDto;
import com.promptoven.reviewService.application.port.out.ReviewRepositoryPort;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryPort {

    private final ReviewJpaRepository reviewJpaRepository;
    private final ReviewEntityMapper reviewEntityMapper;
    private final JPAQueryFactory jpaQueryFactory;

    private static final int DEFAULT_PAGE_SIZE = 20;
    private static final int DEFAULT_PAGE_NUMBER = 0;

    @Override
    public ReviewEntity save(ReviewOutPortDto reviewOutPortDto) {
        ReviewEntity reviewEntity = reviewEntityMapper.toEntity(reviewOutPortDto);
        return reviewJpaRepository.save(reviewEntity);
    }

    @Override
    public ReviewEntity update(ReviewOutPortDto reviewOutPortDto) {
        ReviewEntity reviewEntity = reviewEntityMapper.toUpdateEntity(reviewOutPortDto);
        return reviewJpaRepository.save(reviewEntity);
    }

    @Override
    public Optional<ReviewOutPortDto> getReviewByReviewId(Long reviewId) {
        return reviewJpaRepository.findByReviewIdAndIsDeletedFalse(reviewId).map(reviewEntityMapper::toDto);
    }

    @Override
    public ReviewEntity delete(ReviewOutPortDto reviewOutPortDto) {
        ReviewEntity reviewEntity = reviewEntityMapper.toDeleteEntity(reviewOutPortDto);
        return reviewJpaRepository.save(reviewEntity);
    }
}

