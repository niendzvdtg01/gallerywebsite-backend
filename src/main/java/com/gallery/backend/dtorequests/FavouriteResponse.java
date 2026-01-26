package com.gallery.backend.dtorequests;

public class FavouriteResponse {
    private Long favouriteId;
    private Long photoId;
    private String unsplashId;
    private String imageUrl;

    public FavouriteResponse(Long favouriteId, Long photoId, String unsplashId, String imageUrl) {
        this.favouriteId = favouriteId;
        this.photoId = photoId;
        this.unsplashId = unsplashId;
        this.imageUrl = imageUrl;
    }

    public Long getFavouriteId() {
        return this.favouriteId;
    }

    public void setFavouriteId(Long favouriteId) {
        this.favouriteId = favouriteId;
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