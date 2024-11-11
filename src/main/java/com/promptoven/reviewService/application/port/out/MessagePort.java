package com.promptoven.reviewService.application.port.out;

public interface MessagePort {
    void createReviewMessage(MessageOutDto messageOutDto);
    void updateReviewMessage(MessageOutDto messageOutDto);
    void deleteReviewMessage(MessageOutDto messageOutDto);
}
