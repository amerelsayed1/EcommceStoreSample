package io.amermahsoub.ecommerce_store.services;

import io.amermahsoub.ecommerce_store.entities.Category;
import io.amermahsoub.ecommerce_store.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {return  categoryRepository.save(category);}

    public void deleteCategory(Category category) { categoryRepository.delete(category);}

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

}
