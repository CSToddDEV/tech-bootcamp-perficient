package com.perficient.techbootcampcalvintodd.controller;

import com.perficient.techbootcampcalvintodd.repository.BrandRepository;
import com.perficient.techbootcampcalvintodd.entity.Brand;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
public class BrandController {

    private final BrandRepository repository;

    BrandController(BrandRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/brands")
    List<Brand> all() {
        return repository.findAll();
    }
}
