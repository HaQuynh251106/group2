package com.example.demo.repository;

import com.example.demo.entity.ProductLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductLogRepository extends JpaRepository<ProductLog, Long> {
    List<ProductLog> findByProductId(Long productId);
}
