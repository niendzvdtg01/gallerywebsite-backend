package com.gallery.backend.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gallery.backend.entity.UnsplashPhoto;

public interface UnsplashPhotoResponsitory extends JpaRepository<UnsplashPhoto, String> {
    //
}
