package io.amermahsoub.ecommerce_store.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data // Equal to serialization in android
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @OneToMany
    private List<Product> products;
}
