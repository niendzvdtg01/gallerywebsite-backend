package com.gallery.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gallery.backend.dtorequests.UpdateUserRequest;
import com.gallery.backend.dtorequests.UserCreation;
import com.gallery.backend.entity.Users;
import com.gallery.backend.respository.UsersRepository;

@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Users createUsers(UserCreation requests) {
        Users user = new Users();
        user.setUsername(requests.getUsername());
        user.setEmail(requests.getEmail());
        user.setFirstname(requests.getFirstname());
        user.setLastname(requests.getLastname());
        // hash password
        String passwordHash = encoder.encode(requests.getUserpassword());
        user.setUserpassword(passwordHash);
        usersRepository.save(user);
        return user;
    }

    public List<Users> getUser(Integer userId) {
        return usersRepository.findByUserId(userId);
    }

    public Integer updateUser(Integer userId, UpdateUserRequest request) {
        return usersRepository.updateUser(userId, request.getEmail(), request.getFirstname(),
                request.getLastname(), request.getProfilePicture(), request.getBio());
    }
}