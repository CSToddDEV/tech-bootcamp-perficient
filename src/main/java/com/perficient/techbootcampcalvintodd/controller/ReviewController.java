package com.perficient.techbootcampcalvintodd.controller;

import com.perficient.techbootcampcalvintodd.aspect.LogExecutionTimeInt;
import com.perficient.techbootcampcalvintodd.exceptions.ReviewNotFound;
import com.perficient.techbootcampcalvintodd.repository.ReviewRepository;
import com.perficient.techbootcampcalvintodd.entity.Review;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    private final ReviewRepository repository;

    ReviewController(ReviewRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/reviews")
    @LogExecutionTimeInt
    List<Review> getAll() {
        return repository.findAll();
    }

    @GetMapping("/reviews/{id}")
    @LogExecutionTimeInt
    Review getReview(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ReviewNotFound(id));
    }

    @PostMapping("/reviews")
    @LogExecutionTimeInt
    Review createReview(@RequestBody Review review) { return repository.save(review); }

    @PutMapping("/reviews/{id}")
    @LogExecutionTimeInt
    Review replaceReview(@PathVariable Long id, @RequestBody Review new_review) {
        return repository.findById(id)
                .map(review -> {
                    review.setRating(new_review.getRating());
                    review.setReviewDate(new_review.getReviewDate());
                    review.setReview(new_review.getReview());
                    review.setProductId(new_review.getProductId());
                    return repository.save(review);
                })
                .orElseGet(() -> {
                    new_review.setId(id);
                    return repository.save(new_review);
                });
    }

    @DeleteMapping("/reviews/{id}")
    @LogExecutionTimeInt
    void deleteReview(@PathVariable Long id) { repository.deleteById(id); }

}
