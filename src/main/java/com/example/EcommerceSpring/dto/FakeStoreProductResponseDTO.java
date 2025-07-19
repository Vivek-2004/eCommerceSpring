package com.example.EcommerceSpring.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreProductResponseDTO {
    String status;
    String message;
    ProductDTO product;
}
