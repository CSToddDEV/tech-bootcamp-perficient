package com.perficient.techbootcampcalvintodd.service;


import com.perficient.techbootcampcalvintodd.aspect.LogExecutionTime;
import com.perficient.techbootcampcalvintodd.entity.Brand;
import com.perficient.techbootcampcalvintodd.entity.Product;
import com.perficient.techbootcampcalvintodd.entity.Review;
import com.perficient.techbootcampcalvintodd.repository.BrandRepository;
import com.perficient.techbootcampcalvintodd.repository.ProductRepository;
import com.perficient.techbootcampcalvintodd.repository.ReviewRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Service
public class BOBService {

    // Declarations
    @Autowired
    BrandRepository brandRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @PersistenceContext
    private EntityManager em;

    // Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(LogExecutionTime.class);

    // Product Methods
    public Iterable<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        Optional<Brand> brand = findBrand(product.getBrand());
        brand.ifPresent(product::setBrand_id);
        return productRepository.save(product);
    }

    public Optional<Product> findProduct (Long ProductID) {
        return productRepository.findById(ProductID);
    }

    public void changeProduct (Long ProductID, Product new_product) {
        productRepository.findById(ProductID)
                .map(old_product -> {
                    old_product.setProduct_name(new_product.getProduct_name());
                    Optional<Brand> brand = brandRepository.findById(new_product.getBrand());
                    brand.ifPresent(old_product::setBrand_id);
                    old_product.setProduct_type(new_product.getProduct_type());
                    old_product.setPrice(new_product.getPrice());
                    old_product.setSold(new_product.getSold());
                    old_product.setRating(new_product.getRating());
                    return productRepository.save(old_product);
                });
    }

    public void deleteProduct ( Long ProductID ) {
        productRepository.deleteById(ProductID);
    }

    // Brand Methods
    public Iterable<Brand> findAllBrands() {
        return brandRepository.findAll();
    }

    public void createBrand(Brand brand) {
        brandRepository.save(brand);
    }

    public Optional<Brand> findBrand (Long BrandID) {
        return brandRepository.findById(BrandID);
    }

    public void updateBrand( Long brandID, Brand new_brand) {
        brandRepository.findById(brandID)
                .map(brand -> {
                    brand.setBrand_name(new_brand.getBrand_name());
                    brand.setBrand_site(new_brand.getBrand_site());
                    brand.setPhone(new_brand.getPhone());
                    return brandRepository.save(brand);
                });
    }

    public void deleteBrand( Long brandID ) {
        brandRepository.deleteById(brandID);
    }

    public List<?> brandReviews(Long id ) {
        Query query = em.createQuery("""
            SELECT b.brand_name, p.product_name, p.product_type, r.rating, r.review
            FROM brand b
            INNER JOIN b.products p
            INNER JOIN p.reviews r
            WHERE b.id = :b
            ORDER BY r.rating DESC""");
        
        query.setParameter("b", id);
        return query.getResultList();
    }

    // Review Methods
    public Iterable<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    public void createReview(Review review) {
        Optional<Product> product= findProduct(review.getProduct_id());
        product.ifPresent(review::setProduct);
        reviewRepository.save(review);
    }

    public Optional<Review> findReview(Long ReviewID) {
        return reviewRepository.findById(ReviewID);
    }

    public void updateReview( Long reviewID, Review new_review) {
        reviewRepository.findById(reviewID)
                .map(review -> {
                    review.setRating(new_review.getRating());
                    review.setReview_date(new_review.getReview_date());
                    review.setReview(new_review.getReview());
                    Optional<Product> product= findProduct(new_review.getProduct_id());
                    product.ifPresent(review::setProduct);
                    return reviewRepository.save(review);
                });
    }

    public void deleteReview( Long reviewID ) {
        reviewRepository.deleteById(reviewID);
    }
}
