package io.amermahsoub.ecommerce_store.services;

import io.amermahsoub.ecommerce_store.dto.ProductResponseDTO;
import io.amermahsoub.ecommerce_store.entities.Category;
import io.amermahsoub.ecommerce_store.entities.Product;
import io.amermahsoub.ecommerce_store.repositories.CategoryRepository;
import io.amermahsoub.ecommerce_store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Product createBook(Product product) {
        return productRepository.save(product);
    }

    public Product getBook(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public Product updateBook(Long bookId, Product productDetails) {
        Product product = productRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setCategoryId(productDetails.getCategoryId());
        return productRepository.save(product);
    }

    public void deleteBook(Product product) {
        productRepository.delete(product);
    }

    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(product -> {
            // Fetch category object using categoryId
            Category category = categoryRepository.findById(product.getCategoryId()).orElse(null);

            // Map to DTO
            return new ProductResponseDTO(
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getDescription(),
                    category // Include full Category object
            );
        }).toList();
    }
}
