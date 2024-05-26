package com.example.travelAgency.mappers;

import com.example.travelAgency.dto.categoryDTOs.CategoryDTO;
import com.example.travelAgency.dto.categoryDTOs.ResponseCategoryDTO;
import com.example.travelAgency.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public ResponseCategoryDTO mapToCategoryDTO(Category category) {
//        return ResponseCategoryDTO.builder()
//                .categoryId(category.getCategoryId())
//                .categoryName(category.getCategoryName())
//                .build();

        ResponseCategoryDTO responseCategoryDto = new ResponseCategoryDTO();
        responseCategoryDto.setCategoryName(category.getCategoryName());
        responseCategoryDto.setCategoryId(category.getCategoryId());
        return  responseCategoryDto;
    }

    public Category mapToCategoryEntity(CategoryDTO categoryDTO) {
//        return Category.builder()
//                .categoryName(categoryDTO.getCategoryName())
//                .build();

        Category category = new Category();
        category.setCategoryName(categoryDTO.getCategoryName());
        return category;
    }
}
