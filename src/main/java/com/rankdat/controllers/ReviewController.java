package com.rankdat.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rankdat.models.Review;
import com.rankdat.repository.ReviewRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    Logger log = LoggerFactory.getLogger(ReviewController.class);

    @Autowired
    ReviewRepository repository;

    @GetMapping
    public List<Review> getAllReviews() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Review> getReviewId(@PathVariable Long id) {
        log.info("buscando uma review com id: " + id);
        var reviewEncontrada = repository.findById(id);

        if(reviewEncontrada.isEmpty())
            return ResponseEntity.notFound().build();
        
        return ResponseEntity.ok(reviewEncontrada.get());

    }

    @PostMapping
    public ResponseEntity<Review> postReview(@RequestBody @Valid Review review) {
        log.info("cadastrando uma review: " + review);

        repository.save(review);

        return ResponseEntity.status(HttpStatus.CREATED).body(review);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Review> deleteReview(@PathVariable Long id) {
        log.info("excluindo uma review com id: " + id);
        var reviewEncontrada = repository.findById(id);
        
        if(reviewEncontrada.isEmpty())
            return ResponseEntity.notFound().build();
        

        repository.delete(reviewEncontrada.get());

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Review> putReview(@PathVariable Long id, @RequestBody @Valid Review review) {
        log.info("alterando uma review com id: " + id);
        var reviewEncontrada = repository.findById(id);

        if(reviewEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        
        review.setId(id);
        repository.save(review);

        return ResponseEntity.ok(review);

    }
    
}
