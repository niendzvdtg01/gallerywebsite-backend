package com.gallery.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "UnsplashPhto")
public class UnsplashPhoto {
    @Id
    @Column(name = "unsplash_id", nullable = false)
    private String unsplashId;
    @Column(name = "unsplash_url")
    private String unsplashUrl;
    @Column(name = "unsplash_title")
    private String unsplashTitle;
    @Column(name = "unsplash_description")
    private String unsplashDescription;

    public UnsplashPhoto(String unsplashId, String unsplashUrl, String unsplashTitle, String unsplashDescription) {
        this.unsplashId = unsplashId;
        this.unsplashUrl = unsplashUrl;
        this.unsplashTitle = unsplashTitle;
        this.unsplashDescription = unsplashDescription;
    }

    public UnsplashPhoto() {

    }

    public String getUnsplashId() {
        return this.unsplashId;
    }

    public void setUnsplashId(String unsplashId) {
        this.unsplashId = unsplashId;
    }

    public String getUnsplashUrl() {
        return this.unsplashUrl;
    }

    public void setUnsplashUrl(String unsplashUrl) {
        this.unsplashUrl = unsplashUrl;
    }

    public String getUnsplashTitle() {
        return this.unsplashTitle;
    }

    public void setUnsplashTitle(String unsplashTitle) {
        this.unsplashTitle = unsplashTitle;
    }

    public String getUnsplashDescription() {
        return this.unsplashDescription;
    }

    public void setUnsplashDescription(String unsplashDescription) {
        this.unsplashDescription = unsplashDescription;
    }
}
