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

import jakarta.servlet.http.Cookie;
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
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Users user = authService.athencate(request.getUsername(), request.getUserpassword());

        String token = JwtsUtil.generateToken(user);
        // Tao response cookie
        if (user == null) {
            return ResponseEntity.status(401).body("Login failed");
        }
        ResponseCookie cookie = ResponseCookie.from("access_cookie", token)
                .httpOnly(true)
                .secure(true)
                .sameSite("None")
                .path("/")
                .maxAge(Duration.ofMinutes(60))
                .build();

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body("Login succesfully!");
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("access_cookie", null);
        cookie.setPath("/");
        cookie.setDomain("https://twild-gallery.vercel.app");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return ResponseEntity.ok().build();
    }
}
