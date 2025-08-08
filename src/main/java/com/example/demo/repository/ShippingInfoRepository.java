package com.example.demo.repository;

import com.example.demo.entity.ShippingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShippingInfoRepository extends JpaRepository<ShippingInfo, Long> {
    List<ShippingInfo> findByUserId(Long userId);
    List<ShippingInfo> findByOrderId(Long orderId);
}
