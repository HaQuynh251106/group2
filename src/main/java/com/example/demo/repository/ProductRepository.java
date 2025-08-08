package com.example.demo.repository;

import com.example.demo.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Long> {
    List<Products> findByNameContaining(String keyword);
    List<Products> findByCategoryId(Long categoryId);
}
