package com.example.ecommerceapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRODUCTS_SKUS")
public class ProductSku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "SIZE_ATTRIBUTE_ID", nullable = false)
    private ProductAttribute sizeAttribute;

    @ManyToOne
    @JoinColumn(name = "COLOR_ATTRIBUTE_ID", nullable = false)
    private ProductAttribute colorAttribute;

    private String sku;
    private String price;
    private Integer quantity;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductAttribute getSizeAttribute() {
        return sizeAttribute;
    }

    public void setSizeAttribute(ProductAttribute sizeAttribute) {
        this.sizeAttribute = sizeAttribute;
    }

    public ProductAttribute getColorAttribute() {
        return colorAttribute;
    }

    public void setColorAttribute(ProductAttribute colorAttribute) {
        this.colorAttribute = colorAttribute;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}