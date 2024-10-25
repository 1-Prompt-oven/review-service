package com.promptoven.reviewService.adaptor.out.mysql.repository;

import com.promptoven.reviewService.adaptor.out.mysql.mapper.ReviewEntityMapper;
import com.promptoven.reviewService.application.port.out.ReviewRepositoryPort;
import com.promptoven.reviewService.application.port.out.ReviewOutPortDto;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryPort {

    private final ReviewJpaRepository reviewJpaRepository;
    private final ReviewEntityMapper reviewEntityMapper;

    @Override
    public void save(ReviewOutPortDto reviewOutPortDto) {
        reviewJpaRepository.save(reviewEntityMapper.toEntity(reviewOutPortDto));
    }

    @Override
    public void update(ReviewOutPortDto reviewOutPortDto) {
        reviewJpaRepository.save(reviewEntityMapper.toUpdateEntity(reviewOutPortDto));
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
        reviewJpaRepository.save(reviewEntityMapper.toDeleteEntity(reviewOutPortDto));
    }
}

