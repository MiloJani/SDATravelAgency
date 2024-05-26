package com.example.travelAgency.controller;

import com.example.travelAgency.dto.categoryDTOs.CategoryDTO;
import com.example.travelAgency.dto.categoryDTOs.ResponseCategoryDTO;
import com.example.travelAgency.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
@Tag(name = "CRUD REST APIs for Category Resource")
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(
            summary = "Create Category REST API",
            description = "Create Category REST API is used to save Category into database"
    )
    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATED")
    @PostMapping("/saveCategory")
    public ResponseEntity<ResponseCategoryDTO> save(@RequestBody CategoryDTO categoryDto) {
        return new ResponseEntity<>(categoryService.addCategory(categoryDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Find Category By Id REST API",
            description = "Find Category By Id REST API is used to get a single Category from the database"
    )
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @GetMapping("/findById/{categoryId}")
    public ResponseEntity<ResponseCategoryDTO> findCategoryById(@PathVariable(name = "categoryId") Long categoryId) {
        return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
    }

    @Operation(
            summary = "Find All Categories REST API",
            description = "Find All Categories REST API is used to fetch all the Categories from the database"
    )
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @GetMapping("/findAll")
    public ResponseEntity<List<ResponseCategoryDTO>> findAll() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @Operation(
            summary = "Update Category REST API",
            description = "Update Category REST API is used to update a particular Category in the database"
    )
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @PutMapping("/update/{categoryId}")
    public ResponseEntity<ResponseCategoryDTO> updateCategoryById(@RequestBody CategoryDTO categoryDto, @PathVariable(name = "categoryId") Long categoryId) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryDto, categoryId));
    }

    @Operation(
            summary = "Delete Category REST API",
            description = "Delete Category REST API is used to delete a particular Category from the database"
    )
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @DeleteMapping("/deleteById/{categoryId}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "categoryId") Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category with id: " + categoryId + " was successfully deleted");
    }
}
