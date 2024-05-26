package com.example.travelAgency.service;

import com.example.travelAgency.dto.categoryDTOs.CategoryDTO;
import com.example.travelAgency.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    CategoryDTO getCategoryById(Long id) ;

    CategoryDTO addCategory(Category category) ;

    CategoryDTO updateCategory(Category category, Long id) ;

    Long deleteCategory(Long id) ;
}
