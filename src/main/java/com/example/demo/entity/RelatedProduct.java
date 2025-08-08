package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "related_products")
public class RelatedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Product chính
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;

    // Product liên quan
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "related_id", nullable = false)
    private Products relatedProduct;

    // Getter và Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Products getRelatedProduct() {
        return relatedProduct;
    }

    public void setRelatedProduct(Products relatedProduct) {
        this.relatedProduct = relatedProduct;
    }
}
