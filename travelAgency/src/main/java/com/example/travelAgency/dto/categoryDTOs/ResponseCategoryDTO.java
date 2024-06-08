package com.example.travelAgency.dto.categoryDTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCategoryDTO {

    private Long categoryId;

    @NotBlank(message = "Category name is mandatory")
    private String categoryName;
}

