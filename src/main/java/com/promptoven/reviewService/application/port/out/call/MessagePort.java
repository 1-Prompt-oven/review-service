package com.promptoven.reviewService.application.port.out.call;

import com.promptoven.reviewService.application.port.out.dto.MessageOutDto;
import com.promptoven.reviewService.application.port.out.dto.ReviewOutPortDto;

public interface MessagePort {
    void createReviewMessage(ReviewOutPortDto messageOutDto);
    void updateReviewMessage(MessageOutDto messageOutDto);
    void deleteReviewMessage(ReviewOutPortDto messageOutDto);
}
