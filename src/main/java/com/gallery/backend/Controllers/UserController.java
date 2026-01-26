package com.gallery.backend.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gallery.backend.dtorequests.UpdateUserRequest;
import com.gallery.backend.dtorequests.UserCreation;
import com.gallery.backend.entity.Users;
import com.gallery.backend.respository.UsersRepository;
import com.gallery.backend.services.CloudinaryService;
import com.gallery.backend.services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;
    private final CloudinaryService cloudinaryService;
    @Autowired
    private UsersRepository usersRepository;

    public UserController(UserService userService, CloudinaryService cloudinaryService) {
        this.userService = userService;
        this.cloudinaryService = cloudinaryService;
    }

    @GetMapping(path = "/get_user")
    public @ResponseBody List<Users> getAllUsers(Authentication authentication) {
        int userId = (Integer) authentication.getPrincipal();
        return userService.getUser(userId);
    }

    @PostMapping(path = "/create_user")
    public Users createUser(@RequestBody UserCreation requests) {
        return userService.createUsers(requests);
    }

    @PostMapping(path = "/update_user")
    public ResponseEntity<?> updateuser(@RequestParam("file") MultipartFile file,
            @ModelAttribute UpdateUserRequest request,
            Authentication authentication) {
        try {
            Integer userId = (Integer) authentication.getPrincipal();
            request.setProfilePicture(cloudinaryService.uploadfile(file));
            userService.updateUser(userId, request);
            return ResponseEntity.ok("Upload thanh cong vang doi!!!!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Upload that bai: " + e.getMessage());
        }
    }

}