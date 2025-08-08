package com.example.demo.repository;

import com.example.demo.entity.RelatedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RelatedProductRepository extends JpaRepository<RelatedProduct, Long> {
    List<RelatedProduct> findByProductId(Long productId);
}
