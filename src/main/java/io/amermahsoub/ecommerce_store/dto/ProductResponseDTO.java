package io.amermahsoub.ecommerce_store.dto;

import io.amermahsoub.ecommerce_store.entities.Category;

import java.math.BigDecimal;

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


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
