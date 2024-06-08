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

    @Schema(example = "1")
    private Long categoryId;

    @NotBlank(message = "Category name is mandatory")
    @Schema(example = "SummerTour")
    private String categoryName;
}

