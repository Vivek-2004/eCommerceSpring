//package com.example.EcommerceSpring.services;
//
//import com.example.EcommerceSpring.dto.CategoryDTO;
//import com.example.EcommerceSpring.gateway.ICategoryGateway;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//import java.io.IOException;
//import java.util.List;
//
//@Service
//public class FakeStoreCategoryService implements ICategoryService {
//
//    private final ICategoryGateway categoryGateway;
//
//    public FakeStoreCategoryService(
//            @Qualifier("fakeStoreRestTemplateGateway") ICategoryGateway _categoryGateway
//    ) {
//        categoryGateway = _categoryGateway;
//    }
//
//    @Override
//    public List<CategoryDTO> getAllCategories() throws IOException {
//        return this.categoryGateway.getAllCategories();
//    }
//}