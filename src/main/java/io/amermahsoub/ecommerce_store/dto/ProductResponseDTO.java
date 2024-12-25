package io.amermahsoub.ecommerce_store.dto;

import io.amermahsoub.ecommerce_store.entities.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponseDTO {
    private long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Category category;

    // Constructor
    public ProductResponseDTO(long id, String name, BigDecimal price, String description, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }
}
