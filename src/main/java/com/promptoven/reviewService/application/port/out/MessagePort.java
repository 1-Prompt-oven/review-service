package com.promptoven.reviewService.application.port.out;

public interface MessagePort {
    void createReviewMessage(ReviewOutPortDto messageOutDto);
    void updateReviewMessage(MessageOutDto messageOutDto);
    void deleteReviewMessage(ReviewOutPortDto messageOutDto);
}
