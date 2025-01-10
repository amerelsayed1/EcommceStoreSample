package io.amermahsoub.ecommerce_store.services;

import io.amermahsoub.ecommerce_store.dto.response.ProductResponseDTO;
import io.amermahsoub.ecommerce_store.entities.Category;
import io.amermahsoub.ecommerce_store.entities.Product;
import io.amermahsoub.ecommerce_store.repositories.CategoryRepository;
import io.amermahsoub.ecommerce_store.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    //Create
    public ProductResponseDTO createProduct(ProductResponseDTO productRequest) {
        Category category = categoryRepository.findById(productRequest.getCategoryId()).orElseThrow(() -> new IllegalArgumentException("Category not found"));
        Product product = Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .category(category)
                .description(productRequest.getDescription()).build();
        Product savedProduct = productRepository.save(product);
        return convertToDTO(savedProduct);
    }

    //READ
    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    //READ
    public List<ProductResponseDTO> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    //Using this to convert to DTO
    private ProductResponseDTO convertToDTO(Product product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .categoryId(product.getCategory().getId())
                .build();

    }
}
