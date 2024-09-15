package com.example.ecommerceapi.service;

import com.example.ecommerceapi.exception.ResourceNotFoundException;
import com.example.ecommerceapi.model.ProductSku;
import com.example.ecommerceapi.repository.ProductSkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSkuService {

    @Autowired
    private ProductSkuRepository productSkuRepository;

    public List<ProductSku> getAllProductSkus() {
        return productSkuRepository.findAll();
    }

    public ProductSku getProductSkuById(Long id) {
        return productSkuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProductSku not found with id: " + id));
    }

    public ProductSku createProductSku(ProductSku productSku) {
        return productSkuRepository.save(productSku);
    }

    public ProductSku updateProductSku(Long id, ProductSku productSkuDetails) {
        ProductSku productSku = productSkuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProductSku not found with id: " + id));
        productSku.setProduct(productSkuDetails.getProduct());
        productSku.setSizeAttribute(productSkuDetails.getSizeAttribute());
        productSku.setColorAttribute(productSkuDetails.getColorAttribute());
        productSku.setSku(productSkuDetails.getSku());
        productSku.setPrice(productSkuDetails.getPrice());
        productSku.setQuantity(productSkuDetails.getQuantity());
        productSku.setCreatedAt(productSkuDetails.getCreatedAt());
        productSku.setDeletedAt(productSkuDetails.getDeletedAt());
        return productSkuRepository.save(productSku);
    }

    public void deleteProductSku(Long id) {
        ProductSku productSku = productSkuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProductSku not found with id: " + id));
        productSkuRepository.delete(productSku);
    }
}