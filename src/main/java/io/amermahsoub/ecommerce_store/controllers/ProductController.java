package io.amermahsoub.ecommerce_store.controllers;

import io.amermahsoub.ecommerce_store.dto.response.ProductResponseDTO;
import io.amermahsoub.ecommerce_store.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductResponseDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.createProduct(request));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ProductResponseDTO>> getProducts(@PathVariable Long id) {
        List<ProductResponseDTO> product = productService.getProductsByCategory(id);
        return ResponseEntity.ok(product);
    }

}
