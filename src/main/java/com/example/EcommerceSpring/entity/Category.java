package com.example.EcommerceSpring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;

    // This does not mean that we are trying to store a list of products inside category table.
    // This just tells JPA that the relationship is already owned by the Product entity. So, just read from there.
    // One Category can have multiple products associated with it.
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}