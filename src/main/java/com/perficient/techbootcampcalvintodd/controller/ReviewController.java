package com.perficient.techbootcampcalvintodd.controller;

import com.perficient.techbootcampcalvintodd.aspect.LogExecutionTimeInt;
import com.perficient.techbootcampcalvintodd.exceptions.ReviewNotFound;

import com.perficient.techbootcampcalvintodd.entity.Review;
import com.perficient.techbootcampcalvintodd.service.BOBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    BOBService service;

    ReviewController( ) { }

    @GetMapping("/reviews")
    @LogExecutionTimeInt
    List<Review> getAll() {
        return (List<Review>) service.findAllReviews();
    }

    @GetMapping("/reviews/{id}")
    @LogExecutionTimeInt
    Review getReview(@PathVariable Long id) {
        return service.findReview(id)
                .orElseThrow(() -> new ReviewNotFound(id));
    }

    @PostMapping("/reviews")
    @LogExecutionTimeInt
    void createReview(@RequestBody Review review) { service.createReview(review); }

    @PutMapping("/reviews/{id}")
    @LogExecutionTimeInt
    void replaceReview(@PathVariable Long id, @RequestBody Review new_review) {
         service.updateReview(id, new_review);
    }

//    @DeleteMapping("/reviews/{id}")
//    @LogExecutionTimeInt
//    void deleteReview(@PathVariable Long id) { service.deleteById(id); }
//
}
