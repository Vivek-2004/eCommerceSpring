package com.example.EcommerceSpring.controllers;

import com.example.EcommerceSpring.dto.AllProductsOfCategoryDTO;
import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.services.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// CONTROLLER -> SERVICE -> API GATEWAY / REPOSITORY

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    //@Autowired        // NOT RECOMMENDED BECAUSE WE CANNOT USE FINAL KEYWORD
    private final ICategoryService categoryService;

    CategoryController(ICategoryService _categoryService) {
        this.categoryService = _categoryService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false) String name) throws Exception {
        if(name != null && !name.isBlank()) {
            CategoryDTO category = categoryService.getByName(name);
            return ResponseEntity.status(200).body(category);
        }
        List<CategoryDTO> result = categoryService.getAllCategories();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO created = categoryService.createCategory(categoryDTO);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<AllProductsOfCategoryDTO> allProductsOfCategoryDTO(@PathVariable Long id) throws Exception {
        AllProductsOfCategoryDTO allProducts = categoryService.getAllProductsOfCategory(id);
        return ResponseEntity.ok(allProducts);
    }

}