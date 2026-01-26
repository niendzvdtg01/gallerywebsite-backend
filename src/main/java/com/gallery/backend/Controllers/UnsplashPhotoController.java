package com.gallery.backend.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gallery.backend.dtorequests.UnsplashPhotoCreation;
import com.gallery.backend.entity.UnsplashPhoto;
import com.gallery.backend.services.UnplashService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/unsplash")
public class UnsplashPhotoController {
    private final UnplashService unplashService;

    public UnsplashPhotoController(UnplashService unplashService) {
        this.unplashService = unplashService;
    }

    @PostMapping(path = "/post")
    public UnsplashPhoto insertUnsplashPhoto(@RequestBody UnsplashPhotoCreation requests) {
        return unplashService.saveUnsplash(requests);
    }
}
