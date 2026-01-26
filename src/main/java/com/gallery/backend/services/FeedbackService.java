package com.gallery.backend.services;

import org.springframework.stereotype.Service;

import com.gallery.backend.dtorequests.FeedbackCreation;
import com.gallery.backend.entity.Feedback;
import com.gallery.backend.respository.FeedbackRespository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    private final FeedbackRespository feedbackRespository;

    public Feedback saveFeedback(FeedbackCreation request) {
        Feedback feedback = new Feedback();
        feedback.setFullName(request.getFullName());
        feedback.setEmail(request.getEmail());
        feedback.setScore(request.getScore());
        feedback.setScoreReason(request.getScoreReason());
        feedback.setImprovement(request.getImprovement());
        feedback.setGoodExperience(request.getGoodExperience());
        return feedbackRespository.save(feedback);
    }
}
