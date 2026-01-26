package com.gallery.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gallery.backend.dtorequests.PhotoCreation;
import com.gallery.backend.entity.Photo;
import com.gallery.backend.entity.Users;
import com.gallery.backend.respository.PhotoResponsitory;
import com.gallery.backend.respository.UsersRepository;

@Service
public class PhotoService {
    private final PhotoResponsitory photoResponsitory;
    private final UsersRepository usersRepository;

    public PhotoService(PhotoResponsitory photoResponsitory, UsersRepository usersRepository) {
        this.photoResponsitory = photoResponsitory;
        this.usersRepository = usersRepository;
    }

    public Photo savePhoto(PhotoCreation requests, Integer userId) {
        Photo photo = new Photo();
        Users user = usersRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found!!!"));
        photo.setImgUrl(requests.getImageUrl());
        photo.setUserId(user);
        photo.setTitle(requests.getTitle());
        photo.setDescriptions(requests.getDescriptions());
        photoResponsitory.save(photo);
        return photo;
    }

    public List<Photo> getPhotoUpload(Integer userId) {
        Users user = usersRepository.findById(userId).orElseThrow(() -> new RuntimeException("Users not found!!!"));
        return photoResponsitory.findByUserId(user);
    }
}
