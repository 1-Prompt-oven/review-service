package com.promptoven.reviewService.adaptor.in.kafka.controller;

import com.promptoven.reviewService.application.port.in.ReviewUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final ReviewUseCase reviewUseCase;

    @PostMapping
    public void testEvent() {
        reviewUseCase.aggregateReviewData();
        System.out.println("testEvent");
    }
}
