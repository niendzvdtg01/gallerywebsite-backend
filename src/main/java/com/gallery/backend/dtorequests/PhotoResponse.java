package com.gallery.backend.dtorequests;

public class PhotoResponse {
    private Long photoId;
    private String unsplashId;
    private String imageUrl;
    private String title;
    private String descriptions;

    public PhotoResponse(String imageUrl, String title, String descriptions, Long photoId, String unsplashId) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.descriptions = descriptions;
        this.photoId = photoId;
        this.unsplashId = unsplashId;
    }

    public Long getPhotoId() {
        return this.photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }

    public String getUnsplashId() {
        return this.unsplashId;
    }

    public void setUnsplashId(String unsplashId) {
        this.unsplashId = unsplashId;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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