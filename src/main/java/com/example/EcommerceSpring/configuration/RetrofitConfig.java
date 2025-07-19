package com.example.EcommerceSpring.configuration;

import com.example.EcommerceSpring.gateway.api.FakeStoreCategoryApi;
import com.example.EcommerceSpring.gateway.api.FakeStoreProductApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;

@Configuration
public class RetrofitConfig {

    @Value("${base.url}")
    private String baseUrl;

    @Bean
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }

    @Bean
    public FakeStoreCategoryApi fakeStoreCategoryApi(Retrofit retrofit) {
        return retrofit.create(FakeStoreCategoryApi.class);
    }

    @Bean
    public FakeStoreProductApi fakeStoreProductApi(Retrofit retrofit) {
        return retrofit.create(FakeStoreProductApi.class);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }

}