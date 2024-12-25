package io.amermahsoub.ecommerce_store.repositories;

import io.amermahsoub.ecommerce_store.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findBookById(Long id);
}
