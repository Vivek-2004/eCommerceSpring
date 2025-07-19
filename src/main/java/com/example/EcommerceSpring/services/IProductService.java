package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.ProductDTO;
import java.io.IOException;

public interface IProductService {

    ProductDTO getProductById(Long id) throws IOException;

    ProductDTO createProduct(ProductDTO dto) throws Exception;

}