package io.amermahsoub.ecommerce_store.controllers;

import io.amermahsoub.ecommerce_store.dto.ProductResponseDTO;
import io.amermahsoub.ecommerce_store.entities.Product;
import io.amermahsoub.ecommerce_store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    ResponseEntity<Product> createBook(@RequestBody Product product) {
        Product createdProduct = productService.createBook(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @GetMapping
    ResponseEntity<List<ProductResponseDTO>> getAllBooks() {
        List<ProductResponseDTO> createdProduct = productService.getAllProducts();
        return ResponseEntity.status(200).body(createdProduct);
    }
}
