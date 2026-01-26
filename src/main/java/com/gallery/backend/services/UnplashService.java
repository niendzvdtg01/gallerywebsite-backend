package com.gallery.backend.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gallery.backend.Properties.UnplashProperties;
import com.gallery.backend.dtorequests.PhotoResponse;
import com.gallery.backend.dtorequests.UnsplashPhotoCreation;
import com.gallery.backend.dtorequests.UnsplashCreation.UnsplashCreation;
import com.gallery.backend.dtorequests.UnsplashCreation.UnsplashSearchResponse;
import com.gallery.backend.entity.UnsplashPhoto;
import com.gallery.backend.respository.PhotoResponsitory;
import com.gallery.backend.respository.UnsplashPhotoResponsitory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UnplashService {

        private final PhotoResponsitory photoResponsitory;
        private final UnplashProperties props;
        private final UnsplashPhotoResponsitory unsplashPhtoResponsitory;

        private final RestTemplate restTemplate = new RestTemplate();

        private HttpHeaders headers() {
                HttpHeaders h = new HttpHeaders();
                h.set("Authorization", "Client-ID " + props.getAccessKey());
                return h;
        }

        public List<PhotoResponse> getPhoto() {
                String url = "https://api.unsplash.com/photos?per_page=20";

                HttpEntity<Void> entity = new HttpEntity<>(headers());
                UnsplashCreation[] res = restTemplate.exchange(url, HttpMethod.GET, entity, UnsplashCreation[].class)
                                .getBody();
                List<PhotoResponse> unsplashPhtos = Arrays.stream(res)
                                .map(p -> new PhotoResponse(p.getUrls().getSmall(), p.getUser().getName(),
                                                p.getDescription(),
                                                null, p.getId()))
                                .toList();
                List<PhotoResponse> userPhotos = photoResponsitory.findAll().stream()
                                .map(p -> new PhotoResponse(p.getImgUrl(), p.getTitle(), p.getDescriptions(),
                                                p.getPhotoId(), null))
                                .toList();
                List<PhotoResponse> results = new ArrayList<>();
                results.addAll(unsplashPhtos);
                results.addAll(userPhotos);
                return results;
        }

        public List<PhotoResponse> searchPhoto(String keyword) {
                String url = "https://api.unsplash.com/search/photos" + "?query=" + keyword + "&per_page=30";

                HttpEntity<Void> entity = new HttpEntity<>(headers());

                UnsplashSearchResponse res = restTemplate
                                .exchange(url, HttpMethod.GET, entity, UnsplashSearchResponse.class)
                                .getBody();

                return res.getResults().stream()
                                .map(p -> new PhotoResponse(p.getUrls().getSmall(), p.getUser().getName(),
                                                p.getDescription(),
                                                null, p.getId()))
                                .toList();
        }

        public UnsplashPhoto saveUnsplash(UnsplashPhotoCreation requests) {
                try {
                        UnsplashPhoto unsplashPhoto = new UnsplashPhoto();
                        unsplashPhoto.setUnsplashId(requests.getUnsplashId());
                        unsplashPhoto.setUnsplashUrl(requests.getUnsplashUrl());
                        unsplashPhoto.setUnsplashTitle(requests.getUnsplashTitle());
                        unsplashPhoto.setUnsplashDescription(requests.getUnsplashDescription());
                        return unsplashPhtoResponsitory.save(unsplashPhoto);
                } catch (DataIntegrityViolationException e) {
                        return unsplashPhtoResponsitory.findById(requests.getUnsplashId()).orElseThrow();
                }
        }
}