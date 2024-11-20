package com.promptoven.reviewService.adaptor.mysql.repository;

import com.promptoven.reviewService.adaptor.mysql.entity.ReviewEntity;
import com.promptoven.reviewService.adaptor.mysql.mapper.ReviewEntityMapper;
import com.promptoven.reviewService.application.port.out.dto.ReviewOutPortDto;
import com.promptoven.reviewService.application.port.out.call.ReviewRepositoryPort;
import com.promptoven.reviewService.application.port.out.dto.ReviewPersistenceDto;
import com.promptoven.reviewService.application.port.out.dto.ReviewQueryDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
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
    public ReviewOutPortDto save(ReviewPersistenceDto reviewOutPortDto) {
        ReviewEntity reviewEntity = reviewEntityMapper.toEntity(reviewOutPortDto);
        return reviewEntityMapper.toDto(reviewJpaRepository.save(reviewEntity));
    }

    @Override
    public ReviewOutPortDto update(ReviewPersistenceDto reviewOutPortDto) {
        ReviewEntity reviewEntity = reviewEntityMapper.toUpdateEntity(reviewOutPortDto);
        return reviewEntityMapper.toDto(reviewJpaRepository.save(reviewEntity));
    }

    @Override
    public Optional<ReviewQueryDto> getReviewByReviewId(Long reviewId) {
        return reviewJpaRepository.findByReviewIdAndIsDeletedFalse(reviewId).map(reviewEntityMapper::toQueryDto);
    }

    @Override
    public List<ReviewOutPortDto> getReviewListByAuthorUuid(String authorUuid) {
        return reviewJpaRepository.findAllByauthorUuid(authorUuid).stream()
                .map(reviewEntityMapper::toDto)
                .toList();
    }

    @Override
    public ReviewOutPortDto delete(ReviewPersistenceDto reviewOutPortDto) {
        ReviewEntity reviewEntity = reviewEntityMapper.toDeleteEntity(reviewOutPortDto);
        return reviewEntityMapper.toDto(reviewJpaRepository.save(reviewEntity));
    }
}

