package com.example.ecommerceapi.controller;

import com.example.ecommerceapi.model.ProductAttribute;
import com.example.ecommerceapi.service.ProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-attributes")
public class ProductAttributeController {

    @Autowired
    private ProductAttributeService productAttributeService;

    @GetMapping
    public List<ProductAttribute> getAllProductAttributes() {
        return productAttributeService.getAllProductAttributes();
    }

    @GetMapping("/{id}")
    public ProductAttribute getProductAttributeById(@PathVariable Long id) {
        return productAttributeService.getProductAttributeById(id);
    }

    @PostMapping
    public ProductAttribute createProductAttribute(@RequestBody ProductAttribute productAttribute) {
        return productAttributeService.createProductAttribute(productAttribute);
    }

    @PutMapping("/{id}")
    public ProductAttribute updateProductAttribute(@PathVariable Long id, @RequestBody ProductAttribute productAttributeDetails) {
        return productAttributeService.updateProductAttribute(id, productAttributeDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteProductAttribute(@PathVariable Long id) {
        productAttributeService.deleteProductAttribute(id);
    }
}