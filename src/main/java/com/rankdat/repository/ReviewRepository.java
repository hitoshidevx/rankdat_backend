package com.rankdat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rankdat.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    
}
