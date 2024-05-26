package com.example.travelAgency.mappers;

import com.example.travelAgency.dto.CategoryDTO;
import com.example.travelAgency.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryDTO mapToCategoryDTO(Category category) {
        return CategoryDTO.builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .build();
    }

    public Category mapToCategoryEntity(CategoryDTO categoryDTO) {
        return Category.builder()
                .categoryId(categoryDTO.getCategoryId())
                .categoryName(categoryDTO.getCategoryName())
                .build();
    }
}
