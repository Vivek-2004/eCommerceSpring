package com.example.EcommerceSpring.mappers;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.dto.ProductWithCategoryDTO;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.entity.Product;

public class ProductMapper {
    public static ProductDTO toDto(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .brand(product.getBrand())
                .model(product.getModel())
                .color(product.getColor())
                .price(product.getPrice())
                .image(product.getImage())
                .categoryId(product.getCategory().getId())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .popular(product.isPopular())
                .build();
    }

    public static Product toEntity(ProductDTO dto, Category category) {
        return Product.builder()
                .title(dto.getTitle())
                .brand(dto.getBrand())
                .model(dto.getModel())
                .color(dto.getColor())
                .price(dto.getPrice())
                .image(dto.getImage())
                .category(category)
                .description(dto.getDescription())
                .discount(dto.getDiscount())
                .popular(dto.isPopular())
                .build();
    }

    public static ProductWithCategoryDTO toProductWithCategoryDTO(Product product) {
        return ProductWithCategoryDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .brand(product.getBrand())
                .model(product.getModel())
                .color(product.getColor())
                .price(product.getPrice())
                .image(product.getImage())
                .categoryId(product.getCategory().getId())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .popular(product.isPopular())
                .category(CategoryMapper.toDTO(product.getCategory()))
                .build();
    }
}