package com.example.EcommerceSpring.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductWithCategoryDTO {
    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    private long id;
    private String title;
    private Long categoryId;
    private String brand;
    private boolean popular;
    private CategoryDTO category;
}