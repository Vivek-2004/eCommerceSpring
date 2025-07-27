package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.dto.ProductWithCategoryDTO;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.entity.Product;
import com.example.EcommerceSpring.exception.ProductNotFoundException;
import com.example.EcommerceSpring.mappers.ProductMapper;
import com.example.EcommerceSpring.repository.CategoryRepository;
import com.example.EcommerceSpring.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service  // ("productService")
@Primary
public class ProductService implements IProductService {

    private final ProductRepository repo;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository _repo, CategoryRepository _categoryRepository) {
        this.repo = _repo;
        this.categoryRepository = _categoryRepository;
    }

    @Override
    public ProductDTO getProductById(Long id) {
//        return repo.findById(id).map(ProductMapper::toDto).orElseThrow(() -> new IOException("Product Not Found"));

        Product product = repo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with ID: " + id + " Not Found."));
        ProductDTO dto = ProductMapper.toDto(product);
        return dto;
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) throws Exception {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new Exception("Category Not Found"));
        Product productEntity = ProductMapper.toEntity(dto, category);
        Product savedEntity =  repo.save(productEntity);
        ProductDTO entityToDto = ProductMapper.toDto(savedEntity);
        return entityToDto;
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception {
        Product product = repo.findById(id)
                .orElseThrow(() -> new Exception("Product not found"));
        return ProductMapper.toProductWithCategoryDTO(product);
    }
}