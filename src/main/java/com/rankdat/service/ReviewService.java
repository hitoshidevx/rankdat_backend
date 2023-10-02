package com.rankdat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rankdat.models.ReviewDTO;
import com.rankdat.repository.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository repository;

}
