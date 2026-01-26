package com.gallery.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Favourite")
public class Favourite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favourite_id")
    private long favouriteId;
    @ManyToOne
    @JoinColumn(name = "photo_id")
    private Photo photoId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userId;
    @ManyToOne
    @JoinColumn(name = "unsplash_id")
    private UnsplashPhoto unsplashId;

    public Favourite(long favouriteId, Photo photoId, Users userId, UnsplashPhoto unsplashId) {
        this.favouriteId = favouriteId;
        this.photoId = photoId;
        this.userId = userId;
        this.unsplashId = unsplashId;
    }

    public Favourite() {

    }

    public long getFavouriteId() {
        return this.favouriteId;
    }

    public void setFavouriteId(long favouriteId) {
        this.favouriteId = favouriteId;
    }

    public Photo getPhotoId() {
        return this.photoId;
    }

    public void setPhotoId(Photo photoId) {
        this.photoId = photoId;
    }

    public Users getUserId() {
        return this.userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public UnsplashPhoto getUnsplashId() {
        return this.unsplashId;
    }

    public void setUnsplashId(UnsplashPhoto unsplashId) {
        this.unsplashId = unsplashId;
    }
}
