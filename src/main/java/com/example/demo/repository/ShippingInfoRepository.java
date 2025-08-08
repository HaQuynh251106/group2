package com.example.demo.repository;

import com.example.demo.entity.ShippingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShippingInfoRepository extends JpaRepository<ShippingInfo, Long> {
    // Tìm ShippingInfo theo userId (thông qua Order -> User -> Id)
    List<ShippingInfo> findByOrder_User_Id(Long userId);

    // Tìm ShippingInfo theo orderId
    List<ShippingInfo> findByOrder_Id(Long orderId);
}
