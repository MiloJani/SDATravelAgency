package com.example.travelAgency.service.impl;

import com.example.travelAgency.dto.CategoryDTO;
import com.example.travelAgency.entity.Category;
import com.example.travelAgency.mappers.CategoryMapper;
import com.example.travelAgency.repository.CategoryRepository;
import com.example.travelAgency.service.CategoryService;
import org.springframework.stereotype.Service;

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
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            return categoryMapper.mapToCategoryDTO(category);
        }
        return null;
    }

    @Override
    public CategoryDTO addCategory(Category category){
        if (!categoryRepository.existsById(category.getCategoryId())) {
            categoryRepository.save(category);
            return categoryMapper.mapToCategoryDTO(category);
        }
        return null;
    }

    @Override
    public CategoryDTO updateCategory(Category category, Long id){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            Category existingCategory = categoryOptional.get();
            existingCategory.setCategoryName(category.getCategoryName());
            categoryRepository.save(existingCategory);
            return categoryMapper.mapToCategoryDTO(existingCategory);
        }
        return null;
    }

    @Override
    public Long deleteCategory(Long id){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            Category existingCategory = categoryOptional.get();
            categoryRepository.delete(existingCategory);
            return id;
        }
        return null;
    }
}
