package com.gallery.backend.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.gallery.backend.entity.Users;

import jakarta.transaction.Transactional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
        Optional<Users> findByUsername(String username);

        // find user
        List<Users> findByUserId(Integer userId);

        @Modifying
        @Transactional
        @Query("""
                        UPDATE Users u
                        SET u.email = :email, u.firstname =:firstname, u.lastname = :lastname, u.profilePicture = :profilePicture, u.bio = :bio
                        WHERE u.userId = :userId
                        """)
        int updateUser(@Param("userId") Integer userId,
                        @Param("email") String email,
                        @Param("firstname") String firstname,
                        @Param("lastname") String lastname,
                        @Param("profilePicture") String profilePicture,
                        @Param("bio") String bio);
}
