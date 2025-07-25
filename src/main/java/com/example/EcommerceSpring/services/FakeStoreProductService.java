package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.dto.ProductWithCategoryDTO;
import com.example.EcommerceSpring.gateway.IProductGateway;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class FakeStoreProductService implements IProductService {

    private final IProductGateway productGateway;

    public FakeStoreProductService(IProductGateway _productGateway) {
        this.productGateway = _productGateway;
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        return this.productGateway.getProductById(id);
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) {
        return null;
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception {
        return null;
    }
}