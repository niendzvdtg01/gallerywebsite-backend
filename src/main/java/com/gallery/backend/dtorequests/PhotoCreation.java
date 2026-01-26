package com.gallery.backend.dtorequests;

public class PhotoCreation {
    private String imageUrl;
    private Integer userId;
    private String title;
    private String descriptions;

    public PhotoCreation(String imageUrl, Integer userId, String title, String descriptions) {
        this.imageUrl = imageUrl;
        this.userId = userId;
        this.title = title;
        this.descriptions = descriptions;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return this.descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}
