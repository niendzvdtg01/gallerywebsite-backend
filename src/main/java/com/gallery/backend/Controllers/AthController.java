package com.gallery.backend.Controllers;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.gallery.backend.dtorequests.LoginRequest;
import com.gallery.backend.entity.Users;
import com.gallery.backend.security.JwtsUtil;
import com.gallery.backend.services.AuthService;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path = "/auth")
public class AthController {
    @Autowired
    private AuthService authService;

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpServletResponse response) {
        Users user = authService.athencate(request.getUsername(), request.getUserpassword());

        String token = JwtsUtil.generateToken(user);
        // Tao response cookie
        ResponseCookie cookie = ResponseCookie.from("access_cookie", token)
                .httpOnly(true)
                .secure(true)
                .sameSite("None").domain("https://gallerywebsite-backend-production.up.railway.app")
                .path("/")
                .maxAge(Duration.ofMinutes(60))
                .build();

        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
        return ResponseEntity.ok("Login successfully!!");
    }
}
