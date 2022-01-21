package com.perficient.techbootcampcalvintodd.controller;

import com.perficient.techbootcampcalvintodd.aspect.LogExecutionTimeInt;
import com.perficient.techbootcampcalvintodd.exceptions.BrandNotFound;
import com.perficient.techbootcampcalvintodd.repository.BrandRepository;
import com.perficient.techbootcampcalvintodd.entity.Brand;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {

    private final BrandRepository repository;

    BrandController(BrandRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/brands")
    @LogExecutionTimeInt
    List<Brand> getAll() {
        return repository.findAll();
    }

    @GetMapping("/brands/{id}")
    @LogExecutionTimeInt
    Brand getBrand(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BrandNotFound(id));
    }

    @PostMapping("/brands")
    @LogExecutionTimeInt
    Brand createBrand(@RequestBody Brand brand) { return repository.save(brand); }

    @PutMapping("/brands/{id}")
    @LogExecutionTimeInt
    Brand replaceBrand(@PathVariable Long id, @RequestBody Brand new_brand) {
        return repository.findById(id)
                .map(brand -> {
                    brand.setBrand_name(new_brand.getBrand_name());
                    brand.setBrand_site(new_brand.getBrand_site());
                    brand.setPhone(new_brand.getPhone());
                    return repository.save(brand);
                })
                .orElseGet(() -> {
                    new_brand.setId(id);
                    return repository.save(new_brand);
                });
    }

    @DeleteMapping("/brands/{id}")
    @LogExecutionTimeInt
    void deleteBrand(@PathVariable Long id) { repository.deleteById(id); }

}

