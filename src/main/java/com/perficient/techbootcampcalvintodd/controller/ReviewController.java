package com.perficient.techbootcampcalvintodd.controller;

import com.perficient.techbootcampcalvintodd.repository.ReviewRepository;
import com.perficient.techbootcampcalvintodd.entity.Review;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
public class ReviewController {

    private final ReviewRepository repository;

    ReviewController(ReviewRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/reviews")
    List<Review> all() {
        return repository.findAll();
    }

}
