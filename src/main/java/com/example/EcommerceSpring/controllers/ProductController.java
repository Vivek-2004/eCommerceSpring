package com.example.EcommerceSpring.controllers;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.services.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("api/product")
public class ProductController {

    IProductService productService;

    ProductController(IProductService _productService) {
        this.productService = _productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) throws IOException {
        ProductDTO result = productService.getProductById(id);
        return ResponseEntity.status(200).body(result);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto) throws Exception {
        ProductDTO result = productService.createProduct(dto);
        return ResponseEntity.status(201).body(result);
    }

}
