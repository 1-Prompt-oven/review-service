package com.promptoven.reviewService.adaptor.mysql.repository;

import com.promptoven.reviewService.adaptor.mysql.entity.ReviewEntity;
import com.promptoven.reviewService.adaptor.mysql.mapper.ReviewEntityMapper;
import com.promptoven.reviewService.application.port.out.call.ReviewRepositoryPort;
import com.promptoven.reviewService.application.port.out.dto.ReviewPersistenceDto;
import com.promptoven.reviewService.application.port.out.dto.ReviewQueryDto;
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

    @Override
    public ReviewPersistenceDto save(ReviewPersistenceDto reviewPersistenceDto) {

        ReviewEntity reviewEntity = reviewEntityMapper.toCreateEntity(reviewPersistenceDto);
        // 리뷰 데이터 저장 후 데이터 리턴
        return reviewEntityMapper.toPersistenceDto(reviewJpaRepository.save(reviewEntity));
    }

    @Override
    public ReviewPersistenceDto update(ReviewPersistenceDto reviewPersistenceDto) {

        ReviewEntity reviewEntity = reviewEntityMapper.toUpdateEntity(reviewPersistenceDto);
        // 리뷰 데이터 저장 후 데이터 리턴
        return reviewEntityMapper.toPersistenceDto(reviewJpaRepository.save(reviewEntity));
    }

    @Override
    public Optional<ReviewQueryDto> getReviewByReviewId(Long reviewId) {
        return reviewJpaRepository.findByIdAndIsDeletedFalse(reviewId).map(reviewEntityMapper::toQueryDto);
    }

    @Override
    public List<ReviewPersistenceDto> getReviewListByAuthorUuid(String authorUuid) {
        return reviewJpaRepository.findAllByAuthorUuid(authorUuid).stream()
                .map(reviewEntityMapper::toPersistenceDto)
                .toList();
    }

    @Override
    public ReviewPersistenceDto delete(ReviewPersistenceDto reviewPersistenceDto) {

        ReviewEntity reviewEntity = reviewEntityMapper.toUpdateEntity(reviewPersistenceDto);
        // 리뷰 데이터 저장 후 데이터 리턴
        return reviewEntityMapper.toPersistenceDto(reviewJpaRepository.save(reviewEntity));
    }
}

