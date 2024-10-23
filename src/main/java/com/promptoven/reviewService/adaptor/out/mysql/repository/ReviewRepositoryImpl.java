package com.promptoven.reviewService.adaptor.out.mysql.repository;

import com.promptoven.reviewService.adaptor.out.mysql.entity.ReviewEntity;
import com.promptoven.reviewService.adaptor.out.mysql.mapper.ReviewEntityMapper;
import com.promptoven.reviewService.application.port.out.ReviewRepositoryPort;
import com.promptoven.reviewService.application.port.out.ReviewTransactionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryPort {

    private final ReviewJpaRepository reviewJpaRepository;
    private final ReviewEntityMapper reviewEntityMapper;

    public void save(ReviewTransactionDto reviewTransactionDto) {
        reviewJpaRepository.save(reviewEntityMapper.toEntity(reviewTransactionDto));
    }

    public void update(ReviewTransactionDto reviewTransactionDto) {
        reviewJpaRepository.save(reviewEntityMapper.toUpdateEntity(reviewTransactionDto));
    }

    @Override
    public ReviewTransactionDto getReviewByReviewId(Long reviewId) {

        ReviewEntity reviewEntity = reviewJpaRepository.findByReviewId(reviewId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found"));

        return reviewEntityMapper.toDto(reviewEntity);
    }
}

