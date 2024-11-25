package com.promptoven.reviewService.adaptor.mysql.repository;

import com.promptoven.reviewService.adaptor.mysql.entity.ReviewEntity;
import com.promptoven.reviewService.adaptor.mysql.mapper.ReviewEntityMapper;
import com.promptoven.reviewService.application.port.out.call.ReviewRepositoryPort;
import com.promptoven.reviewService.application.port.out.dto.ReviewPersistenceDto;
import com.promptoven.reviewService.application.port.out.dto.ReviewQueryDto;
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

    @Override
    public ReviewQueryDto save(ReviewPersistenceDto reviewPersistenceDto) {

        ReviewEntity reviewEntity = reviewEntityMapper.toCreateEntity(reviewPersistenceDto);

        return reviewEntityMapper.toQueryDto(reviewJpaRepository.save(reviewEntity));
    }

    @Override
    public ReviewQueryDto update(ReviewPersistenceDto reviewPersistenceDto) {

        ReviewEntity reviewEntity = reviewEntityMapper.toUpdateEntity(reviewPersistenceDto);

        return reviewEntityMapper.toQueryDto(reviewJpaRepository.save(reviewEntity));
    }

    @Override
    public Optional<ReviewQueryDto> getReviewByReviewId(Long reviewId) {

        return reviewJpaRepository.findByIdAndIsDeletedFalse(reviewId).map(reviewEntityMapper::toQueryDto);
    }

    @Override
    public ReviewQueryDto delete(ReviewPersistenceDto reviewPersistenceDto) {

        ReviewEntity reviewEntity = reviewEntityMapper.toUpdateEntity(reviewPersistenceDto);

        return reviewEntityMapper.toQueryDto(reviewJpaRepository.save(reviewEntity));
    }
}

