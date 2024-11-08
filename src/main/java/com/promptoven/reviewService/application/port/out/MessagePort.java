package com.promptoven.reviewService.application.port.out;

public interface MessagePort {
    void createReviewMessage(MessageDto messageDto);
    void updateReviewMessage(MessageDto messageDto);
    void deleteReviewMessage(MessageDto messageDto);
}
