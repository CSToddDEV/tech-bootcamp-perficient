package com.perficient.techbootcampcalvintodd.repository;

import com.perficient.techbootcampcalvintodd.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

}
