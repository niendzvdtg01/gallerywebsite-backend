package com.gallery.backend.services;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.gallery.backend.dtorequests.FavouriteCreation;
import com.gallery.backend.dtorequests.FavouriteResponse;
import com.gallery.backend.entity.Favourite;
import com.gallery.backend.entity.Photo;
import com.gallery.backend.entity.UnsplashPhoto;
import com.gallery.backend.entity.Users;
import com.gallery.backend.respository.FavouriteResponsitory;
import com.gallery.backend.respository.PhotoResponsitory;
import com.gallery.backend.respository.UnsplashPhotoResponsitory;
import com.gallery.backend.respository.UsersRepository;
import jakarta.transaction.Transactional;

@Service
public class FavouriteService {
    private final FavouriteResponsitory favouriteResponsitory;
    private final UsersRepository usersRepository;
    private final PhotoResponsitory photoResponsitory;
    private final UnsplashPhotoResponsitory unsplashPhtoResponsitory;

    public FavouriteService(FavouriteResponsitory favouriteResponsitory, UsersRepository usersRepository,
            PhotoResponsitory photoResponsitory, UnsplashPhotoResponsitory unsplashPhtoResponsitory) {
        this.favouriteResponsitory = favouriteResponsitory;
        this.usersRepository = usersRepository;
        this.photoResponsitory = photoResponsitory;
        this.unsplashPhtoResponsitory = unsplashPhtoResponsitory;
    }

    @Transactional
    public Favourite saveFavourite(FavouriteCreation requests, Authentication authentication) {
        Favourite favourite = new Favourite();
        Integer userId = (Integer) authentication.getPrincipal();
        if (requests.getPhotoId() != null) {
            Photo photo = photoResponsitory.findById(requests.getPhotoId())
                    .orElseThrow(() -> new RuntimeException("Photo not found!!!"));
            favourite.setPhotoId(photo);
        } else if (requests.getUnsplashId() != null) {
            UnsplashPhoto unsplashPhoto = unsplashPhtoResponsitory.findById(requests.getUnsplashId())
                    .orElseThrow(() -> new RuntimeException("usn[lash photo not found!!!"));
            favourite.setUnsplashId(unsplashPhoto);
        } else {
            throw new RuntimeException("PhotoId and UnsplashId cannot both be null");
        }
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found!!!"));
        favourite.setUserId(user);
        return favouriteResponsitory.save(favourite);
    }

    public List<FavouriteResponse> getFavourite(Integer userId) {
        return favouriteResponsitory.findFavouriteImages(userId);
    }
}