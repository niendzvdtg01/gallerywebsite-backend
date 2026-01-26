package com.gallery.backend.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gallery.backend.dtorequests.FavouriteCreation;
import com.gallery.backend.dtorequests.FavouriteResponse;
import com.gallery.backend.entity.Favourite;
import com.gallery.backend.services.FavouriteService;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path = "/favourite")
public class FavouriteController {
    private final FavouriteService favouriteService;

    public FavouriteController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    @PostMapping(path = "/post")
    public Favourite postFavourite(@RequestBody FavouriteCreation requests, Authentication authentication) {
        return favouriteService.saveFavourite(requests, authentication);
    }

    @GetMapping(path = "/get")
    public List<FavouriteResponse> getFavourite(Authentication authentication) {
        Integer userId = (Integer) authentication.getPrincipal();
        return favouriteService.getFavourite(userId);
    }
}
