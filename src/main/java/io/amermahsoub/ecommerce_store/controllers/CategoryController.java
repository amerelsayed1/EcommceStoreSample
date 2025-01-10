package io.amermahsoub.ecommerce_store.controllers;

import io.amermahsoub.ecommerce_store.dto.CategoryRequestDTO;
import io.amermahsoub.ecommerce_store.entities.Category;
import io.amermahsoub.ecommerce_store.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    ResponseEntity<CategoryRequestDTO> createCategory(@RequestBody CategoryRequestDTO categoryRequest) {
        categoryService.createCategory(categoryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryRequest);
    }

    @GetMapping
    ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categoriesList = categoryService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(categoriesList);
    }

}
