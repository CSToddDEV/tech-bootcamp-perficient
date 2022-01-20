package com.perficient.techbootcampcalvintodd.repository;

import com.perficient.techbootcampcalvintodd.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
