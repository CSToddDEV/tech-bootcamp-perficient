package com.perficient.techbootcampcalvintodd.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="review")
public class Review {

    // Declarations
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long rating;

    @Column(nullable = false)
    private String review_date;

    private String review;

    @Column(nullable = false)
    private Long product_id;

    // Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(Review.class);

    // Constructor Method
    public Review() { }

    // Getter/Setter Methods
    public Long getId() { return id; }
    public void setId(Long id ) { this.id = id; }

    public Long getRating() { return rating; }
    public void setRating(Long rating ) { this.rating = rating; }

    public String getReviewDate() { return review_date; }
    public void setReviewDate(String review_date ) { this.review_date = review_date; }

    public String getReview() { return review; }
    public void setReview(String review ) { this.review = review; }

    public Long getProductId() { return product_id; }
    public void setProductId(Long product_id ) { this.product_id = product_id; }

}
