package com.example.demo.repository;

import com.example.demo.entity.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorites, Long> {
    List<Favorites> findByUserId(Long userId);
}
