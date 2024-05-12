package com.example.Project_Promotion.Repository;

import com.example.Project_Promotion.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(Long id);

    List<Product> findAll();

    Product save(Product existingProduct);

    void deleteById(Long productId);
}
}
