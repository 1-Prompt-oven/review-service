package com.promptoven.reviewService.adaptor.out.mysql.repository;

import com.promptoven.reviewService.adaptor.out.mysql.entity.ReviewEntity;
import com.promptoven.reviewService.adaptor.out.mysql.mapper.ReviewEntityMapper;
import com.promptoven.reviewService.application.port.out.ReviewRepositoryPort;
import com.promptoven.reviewService.application.port.out.ReviewTransactionDto;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryPort {

    private final ReviewJpaRepository reviewJpaRepository;
    private final ReviewEntityMapper reviewEntityMapper;

    @Override
    public void save(ReviewTransactionDto reviewTransactionDto) {
        reviewJpaRepository.save(reviewEntityMapper.toEntity(reviewTransactionDto));
    }
  
    @Override
    public void update(ReviewTransactionDto reviewTransactionDto) {
        reviewJpaRepository.save(reviewEntityMapper.toUpdateEntity(reviewTransactionDto));
    }

    @Override
    public Optional<ReviewTransactionDto> getReviewByReviewId(Long reviewId) {
        return reviewJpaRepository.findByReviewId(reviewId).map(reviewEntityMapper::toDto);
    }

    @Override
    public void delete(ReviewTransactionDto reviewTransactionDto) {
        reviewJpaRepository.save(reviewEntityMapper.toDeleteEntity(reviewTransactionDto));
    }
}

