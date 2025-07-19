package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.FakeStoreProductResponseDTO;
import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.gateway.api.FakeStoreProductApi;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class FakeStoreProductGateway implements IProductGateway{

    private final FakeStoreProductApi fakeStoreProductApi;

    public FakeStoreProductGateway(FakeStoreProductApi _fakeStoreProductApi) {
        this.fakeStoreProductApi = _fakeStoreProductApi;
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException {
        FakeStoreProductResponseDTO response = this.fakeStoreProductApi.getFakeProduct(id).execute().body();
        if(response == null) {
            throw new IOException("Product Not Found");
        }
        return response.getProduct();
    }
}