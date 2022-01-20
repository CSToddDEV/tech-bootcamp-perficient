package com.perficient.techbootcampcalvintodd.repository;

import com.perficient.techbootcampcalvintodd.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
