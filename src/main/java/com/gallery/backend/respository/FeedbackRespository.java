package com.gallery.backend.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gallery.backend.entity.Feedback;

public interface FeedbackRespository extends JpaRepository<Feedback, Long> {
    //
}
