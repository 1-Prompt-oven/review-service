package com.promptoven.reviewService.adaptor.out.mysql.repository;

import com.promptoven.reviewService.adaptor.out.mysql.entity.ReviewEntity;
import com.promptoven.reviewService.adaptor.out.mysql.mapper.ReviewEntityMapper;
import com.promptoven.reviewService.application.port.out.ReviewOutPortDto;
import com.promptoven.reviewService.application.port.out.ReviewRepositoryPort;
import com.promptoven.reviewService.domain.model.Review;
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
    public ReviewOutPortDto save(ReviewOutPortDto reviewOutPortDto) {
        ReviewEntity reviewEntity = reviewEntityMapper.toEntity(reviewOutPortDto);
        return reviewEntityMapper.toDto(reviewJpaRepository.save(reviewEntity));
    }

    @Override
    public ReviewOutPortDto update(ReviewOutPortDto reviewOutPortDto) {
        ReviewEntity reviewEntity = reviewEntityMapper.toUpdateEntity(reviewOutPortDto);
        return reviewEntityMapper.toDto(reviewJpaRepository.save(reviewEntity));
    }

    @Override
    public Optional<ReviewOutPortDto> getReviewByReviewId(Long reviewId) {
        return reviewJpaRepository.findByReviewIdAndIsDeletedFalse(reviewId).map(reviewEntityMapper::toDto);
    }

    @Override
    public List<ReviewOutPortDto> getReviewListByMemberUuid(String memberUuid) {
        return reviewJpaRepository.findAllByMemberUuid(memberUuid).stream()
                .map(reviewEntityMapper::toDto)
                .toList();
    }

    @Override
    public ReviewOutPortDto delete(ReviewOutPortDto reviewOutPortDto) {
        ReviewEntity reviewEntity = reviewEntityMapper.toDeleteEntity(reviewOutPortDto);
        return reviewEntityMapper.toDto(reviewJpaRepository.save(reviewEntity));
    }
}

