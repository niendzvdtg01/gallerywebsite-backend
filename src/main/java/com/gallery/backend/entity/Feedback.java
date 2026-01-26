package com.gallery.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private Long feedbackId;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "email")
    private String email;
    @Column(name = "score")
    private Integer score;
    @Column(name = "score_reason")
    private String scoreReason;
    @Column(name = "improvement")
    private String improvement;
    @Column(name = "good_experience")
    private String goodExperience;

    public Feedback(Long feedbackId, String fullName, String email, int score, String scoreReason, String improvement,
            String goodExperience) {
        this.feedbackId = feedbackId;
        this.fullName = fullName;
        this.email = email;
        this.score = score;
        this.scoreReason = scoreReason;
        this.improvement = improvement;
        this.goodExperience = goodExperience;
    }

    public Feedback() {

    }

    public Long getFeedbackId() {
        return this.feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getScoreReason() {
        return this.scoreReason;
    }

    public void setScoreReason(String scoreReason) {
        this.scoreReason = scoreReason;
    }

    public String getImprovement() {
        return this.improvement;
    }

    public void setImprovement(String improvement) {
        this.improvement = improvement;
    }

    public String getGoodExperience() {
        return this.goodExperience;
    }

    public void setGoodExperience(String goodExperience) {
        this.goodExperience = goodExperience;
    }
}