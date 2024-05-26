package com.example.travelAgency.dto.categoryDTOs;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private Long categoryId;
    private String categoryName;
}

