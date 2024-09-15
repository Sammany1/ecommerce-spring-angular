package com.example.ecommerceapi.service;

import com.example.ecommerceapi.exception.ResourceNotFoundException;
import com.example.ecommerceapi.model.ProductAttribute;
import com.example.ecommerceapi.repository.ProductAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductAttributeService {

    @Autowired
    private ProductAttributeRepository productAttributeRepository;

    public List<ProductAttribute> getAllProductAttributes() {
        return productAttributeRepository.findAll();
    }

    public ProductAttribute getProductAttributeById(Long id) {
        return productAttributeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProductAttribute not found with id: " + id));
    }

    public ProductAttribute createProductAttribute(ProductAttribute productAttribute) {
        return productAttributeRepository.save(productAttribute);
    }

    public ProductAttribute updateProductAttribute(Long id, ProductAttribute productAttributeDetails) {
        ProductAttribute productAttribute = productAttributeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProductAttribute not found with id: " + id));
        productAttribute.setType(productAttributeDetails.getType());
        productAttribute.setValue(productAttributeDetails.getValue());
        productAttribute.setCreatedAt(productAttributeDetails.getCreatedAt());
        productAttribute.setDeletedAt(productAttributeDetails.getDeletedAt());
        return productAttributeRepository.save(productAttribute);
    }

    public void deleteProductAttribute(Long id) {
        ProductAttribute productAttribute = productAttributeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProductAttribute not found with id: " + id));
        productAttributeRepository.delete(productAttribute);
    }
}