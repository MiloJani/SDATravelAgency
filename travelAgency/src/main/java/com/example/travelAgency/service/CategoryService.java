package com.example.travelAgency.service;

import com.example.travelAgency.dto.categoryDTOs.CategoryDTO;
import com.example.travelAgency.dto.categoryDTOs.ResponseCategoryDTO;
import com.example.travelAgency.entity.Category;

import java.util.List;

public interface CategoryService {
    List<ResponseCategoryDTO> getAllCategories();

    ResponseCategoryDTO getCategoryById(Long id) ;

    ResponseCategoryDTO addCategory(CategoryDTO categoryDTO) ;

    ResponseCategoryDTO updateCategory(CategoryDTO categoryDTO, Long id) ;

    void deleteCategory(Long id) ;
}
