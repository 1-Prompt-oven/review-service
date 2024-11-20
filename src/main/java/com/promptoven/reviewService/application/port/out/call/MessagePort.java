package com.promptoven.reviewService.application.port.out.call;

import com.promptoven.reviewService.application.port.out.dto.ReviewPersistenceDto;

public interface MessagePort {

    void createReviewMessage(ReviewPersistenceDto messageOutDto);
//    void updateReviewMessage(MessageOutDto messageOutDto);
//    void deleteReviewMessage(ReviewOutPortDto messageOutDto);
}
