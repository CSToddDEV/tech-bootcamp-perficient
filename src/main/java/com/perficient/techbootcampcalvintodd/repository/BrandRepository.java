package com.perficient.techbootcampcalvintodd.repository;

import com.perficient.techbootcampcalvintodd.entity.Brand;

import org.hibernate.SessionFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {

}
