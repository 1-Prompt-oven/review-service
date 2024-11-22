package com.promptoven.reviewService.application.port.out.call;

import com.promptoven.reviewService.application.port.out.dto.Message.CreateEventMessageDto;
import com.promptoven.reviewService.application.port.out.dto.Message.DeleteEventMessageDto;
import com.promptoven.reviewService.application.port.out.dto.Message.UpdateEventMessageDto;

public interface MessagePort {

    void createReviewMessage(CreateEventMessageDto messageOutDto);

    void updateReviewMessage(UpdateEventMessageDto messageOutDto);

    void deleteReviewMessage(DeleteEventMessageDto messageOutDto);
}
