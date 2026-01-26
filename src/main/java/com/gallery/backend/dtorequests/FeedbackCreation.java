package com.gallery.backend.dtorequests;

public class FeedbackCreation {
    private Long feedbackId;
    private String fullName;
    private String email;
    private Integer score;
    private String scoreReason;
    private String improvement;
    private String goodExperience;

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
