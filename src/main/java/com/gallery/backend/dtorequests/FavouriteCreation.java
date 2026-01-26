package com.gallery.backend.dtorequests;

public class FavouriteCreation {
    private Long favouriteId;
    private Integer userId;
    private Long photoId;
    private String unsplashId;
    private String imageUrl;

    public Long getFavouriteId() {
        return this.favouriteId;
    }

    public void setFavouriteId(Long favouriteId) {
        this.favouriteId = favouriteId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getPhotoId() {
        return this.photoId;
    }

    public void setPhotoId(Long photoId) {
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

}