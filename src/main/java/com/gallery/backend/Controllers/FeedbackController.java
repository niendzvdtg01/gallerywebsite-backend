package com.gallery.backend.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gallery.backend.dtorequests.FeedbackCreation;
import com.gallery.backend.services.FeedbackService;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/feedback")
public class FeedbackController {
    private FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping(path = "/post")
    public ResponseEntity<?> saveFeedback(@RequestBody FeedbackCreation request) {
        feedbackService.saveFeedback(request);
        return ResponseEntity.ok("Upload thanh cong!!!");
    }
}
