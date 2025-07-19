package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.AllProductsOfCategoryDTO;
import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.mappers.CategoryMapper;
import com.example.EcommerceSpring.mappers.ProductMapper;
import com.example.EcommerceSpring.repository.CategoryRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class CategoryService implements ICategoryService {

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository _repo) {
        this.repo = _repo;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        List<CategoryDTO> dtos = new ArrayList<>();
        for(Category x: repo.findAll()) {
            dtos.add(CategoryMapper.toDTO(x));
        }
        return dtos;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category newCategory = CategoryMapper.toEntity(categoryDTO);
        Category saved = repo.save(newCategory);
        return CategoryMapper.toDTO(saved);
    }

    @Override
    public CategoryDTO getByName(String name) throws Exception {
        Category category = repo.findByName(name)
                .orElseThrow(() -> new Exception("Category Not Found with name: " + name));
        return CategoryMapper.toDTO(category);
    }

    @Override
    public AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId) throws Exception {
        Category categoryEntity = repo.findById(categoryId)
                .orElseThrow(() -> new Exception("No Category found with id: " + categoryId));
        List<ProductDTO> products = categoryEntity.getProducts()
                .stream()
                .map(product -> ProductMapper.toDto(product))
                .collect(Collectors.toList());

        return AllProductsOfCategoryDTO.builder()
                .id(categoryId)
                .name(categoryEntity.getName())
                .products(products)
                .build();
    }
}