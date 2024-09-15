package com.example.ecommerceapi.service;

import com.example.ecommerceapi.exception.ResourceNotFoundException;
import com.example.ecommerceapi.model.SubCategory;
import com.example.ecommerceapi.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    public SubCategory getSubCategoryById(Long id) {
        return subCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("SubCategory not found with id: " + id));
    }

    public SubCategory createSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    public SubCategory updateSubCategory(Long id, SubCategory subCategoryDetails) {
        SubCategory subCategory = subCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("SubCategory not found with id: " + id));
        subCategory.setName(subCategoryDetails.getName());
        subCategory.setDescription(subCategoryDetails.getDescription());
        subCategory.setParentCategory(subCategoryDetails.getParentCategory());
        subCategory.setCreatedAt(subCategoryDetails.getCreatedAt());
        subCategory.setDeletedAt(subCategoryDetails.getDeletedAt());
        return subCategoryRepository.save(subCategory);
    }

    public void deleteSubCategory(Long id) {
        SubCategory subCategory = subCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("SubCategory not found with id: " + id));
        subCategoryRepository.delete(subCategory);
    }
}