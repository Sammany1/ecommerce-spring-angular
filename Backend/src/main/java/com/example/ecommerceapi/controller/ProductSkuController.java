package com.example.ecommerceapi.controller;

import com.example.ecommerceapi.model.ProductSku;
import com.example.ecommerceapi.service.ProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-skus")
public class ProductSkuController {

    @Autowired
    private ProductSkuService productSkuService;

    @GetMapping
    public List<ProductSku> getAllProductSkus() {
        return productSkuService.getAllProductSkus();
    }

    @GetMapping("/{id}")
    public ProductSku getProductSkuById(@PathVariable Long id) {
        return productSkuService.getProductSkuById(id);
    }

    @PostMapping
    public ProductSku createProductSku(@RequestBody ProductSku productSku) {
        return productSkuService.createProductSku(productSku);
    }

    @PutMapping("/{id}")
    public ProductSku updateProductSku(@PathVariable Long id, @RequestBody ProductSku productSkuDetails) {
        return productSkuService.updateProductSku(id, productSkuDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteProductSku(@PathVariable Long id) {
        productSkuService.deleteProductSku(id);
    }
}