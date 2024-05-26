package com.example.travelAgency.dto.categoryDTOs;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCategoryDTO {

    private Long categoryId;
    private String categoryName;
}

