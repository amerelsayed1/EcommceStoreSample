package io.amermahsoub.ecommerce_store.services;

import io.amermahsoub.ecommerce_store.dto.request.CategoryRequestDTO;
import io.amermahsoub.ecommerce_store.dto.response.CategoryResponseDTO;
import io.amermahsoub.ecommerce_store.entities.Category;
import io.amermahsoub.ecommerce_store.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequest) {
        Category category = Category.builder()
                .name(categoryRequest.getName())
                .description(categoryRequest.getDescription()).build();
        Category savedCategory = categoryRepository.save(category);
        return convertToDTO(savedCategory);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }


    //Using this to convert to DTO
    private CategoryResponseDTO convertToDTO(Category product) {
        return CategoryResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .build();
    }

}
