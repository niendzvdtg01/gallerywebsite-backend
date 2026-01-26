package com.gallery.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gallery.backend.entity.Users;
import com.gallery.backend.exception.LoginFailException;
import com.gallery.backend.exception.UserNotFoundException;
import com.gallery.backend.respository.UsersRepository;

@Service
public class AuthService {
    @Autowired
    private UsersRepository usersRepository;

    public Users athencate(String username, String rawPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Users user = usersRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
        if (!encoder.matches(rawPassword, user.getUserpassword())) {
            throw new LoginFailException("Login fail!!!");
        }
        return user;
    }
}
