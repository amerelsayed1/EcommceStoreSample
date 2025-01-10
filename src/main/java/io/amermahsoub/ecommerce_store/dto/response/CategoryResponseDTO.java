package io.amermahsoub.ecommerce_store.dto.response;
import lombok.Builder;
import lombok.Data;

@Data //Serialization
@Builder
public class CategoryResponseDTO {
    private Long id;
    private String name;
    private String description;
}
