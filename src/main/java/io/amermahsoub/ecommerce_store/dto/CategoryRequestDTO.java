package io.amermahsoub.ecommerce_store.dto;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data //Serialization
@Builder
public class CategoryRequestDTO {
    @NonNull
    private String name;
    @NonNull()
    private String description;
}
