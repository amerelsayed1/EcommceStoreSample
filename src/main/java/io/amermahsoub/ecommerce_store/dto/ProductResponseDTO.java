package io.amermahsoub.ecommerce_store.dto;

import io.amermahsoub.ecommerce_store.entities.Category;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
public class ProductResponseDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Long categoryId;
}
