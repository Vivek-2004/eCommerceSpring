package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.dto.FakeStoreCategoryResponseDTO;
import com.example.EcommerceSpring.mappers.GetAllCategoriesMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreRestTemplateGateway")
public class FakeStoreRestTemplateGateway implements ICategoryGateway {

    private final RestTemplate restTemplate;

    public FakeStoreRestTemplateGateway(RestTemplate _restTemplate) {
        this.restTemplate = _restTemplate;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        FakeStoreCategoryResponseDTO response  = this.restTemplate.getForObject(
                "https://fakestoreapi.in/api/products/category",
                FakeStoreCategoryResponseDTO.class
        );

        if (response == null) {
            throw new IOException("Failed to fetch Categories from FakeStore API.");
        }

        return GetAllCategoriesMapper.toCategoryDto(response);
    }
}