package com.example.travelAgency.service.impl;

import com.example.travelAgency.constraint.MessageConstraint;
import com.example.travelAgency.dto.categoryDTOs.CategoryDTO;
import com.example.travelAgency.dto.categoryDTOs.ResponseCategoryDTO;
import com.example.travelAgency.entity.Category;
import com.example.travelAgency.mappers.CategoryMapper;
import com.example.travelAgency.repository.CategoryRepository;
import com.example.travelAgency.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    @Override
    public List<ResponseCategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<ResponseCategoryDTO> responseCategoryDTOS = new ArrayList<>();
        for (Category category:categories){
            responseCategoryDTOS.add(categoryMapper.mapToCategoryDTO(category));
        }
        return responseCategoryDTOS;
    }

    @Override
    public ResponseCategoryDTO getCategoryById(Long id) {
        Category foundCategory = categoryRepository.findById(id).orElseThrow(
                ()->new RuntimeException(MessageConstraint.CATEGORY_NOT_FOUND)
        );
        return categoryMapper.mapToCategoryDTO(foundCategory);
    }

    @Override
    public ResponseCategoryDTO addCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.mapToCategoryEntity(categoryDTO);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.mapToCategoryDTO(savedCategory);
    }

    @Override
    public ResponseCategoryDTO updateCategory(CategoryDTO categoryDTO, Long id) {
        Category foundCategory = categoryRepository.findById(id).orElseThrow(
                ()->new RuntimeException(MessageConstraint.CATEGORY_NOT_FOUND)
        );
        foundCategory.setCategoryName(categoryDTO.getCategoryName());
        Category updatedCategory = categoryRepository.save(foundCategory);
        return categoryMapper.mapToCategoryDTO(updatedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        Category foundCategory = categoryRepository.findById(id).orElseThrow(
                ()->new RuntimeException(MessageConstraint.CATEGORY_NOT_FOUND)
        );
        categoryRepository.delete(foundCategory);
    }
}
