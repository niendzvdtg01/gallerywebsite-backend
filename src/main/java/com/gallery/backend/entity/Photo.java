package com.gallery.backend.entity;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    private Long photoId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userId;
    @Column(name = "image_url")
    private String imgUrl;
    @Column(name = "title")
    private String title;
    @Column(name = "descriptions")
    private String descriptions;
    @Column(name = "upload_date")
    private Date uploadDate;
    @Column(name = "view_count")
    private Integer viewCount;
    @Column(name = "likescount")
    private Integer likeCount;

    public Photo() {

    }

    public Photo(Long photoId, Users userId, String imgUrl, String title, String descriptions, Date uploadDate,
            Integer viewCount, Integer likeCount) {
        this.photoId = photoId;
        this.userId = userId;
        this.imgUrl = imgUrl;
        this.title = title;
        this.descriptions = descriptions;
        this.uploadDate = uploadDate;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
    }

    public Long getPhotoId() {
        return this.photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public Users getUserId() {
        return this.userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public Date getUploadDate() {
        return this.uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getViewCount() {
        return this.viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getLikeCount() {
        return this.likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }
}