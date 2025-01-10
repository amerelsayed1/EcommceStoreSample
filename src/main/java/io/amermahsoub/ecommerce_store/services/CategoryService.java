package io.amermahsoub.ecommerce_store.services;

import io.amermahsoub.ecommerce_store.dto.CategoryRequestDTO;
import io.amermahsoub.ecommerce_store.entities.Category;
import io.amermahsoub.ecommerce_store.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategory(CategoryRequestDTO categoryRequest) {
        Category category = Category.builder().name(categoryRequest.getName()).description(categoryRequest.getDescription()).build();
        return categoryRepository.save(category);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

}
