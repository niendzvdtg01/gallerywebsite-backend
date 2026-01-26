package com.gallery.backend.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gallery.backend.entity.Photo;
import com.gallery.backend.entity.Users;

import java.util.List;

public interface PhotoResponsitory extends JpaRepository<Photo, Long> {
    List<Photo> findByUserId(Users userId);
}
