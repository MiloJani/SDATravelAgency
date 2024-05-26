package com.example.travelAgency.controller;

import com.example.travelAgency.dto.categoryDTOs.CategoryDTO;
import com.example.travelAgency.entity.Category;
import com.example.travelAgency.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    ResponseEntity<String> addCategory(@RequestBody Category category){
        CategoryDTO categoryDTO = categoryService.addCategory(category);
        return ResponseEntity.ok("Category me id:"+categoryDTO.getCategoryId()+" u krijua");

    }
}
