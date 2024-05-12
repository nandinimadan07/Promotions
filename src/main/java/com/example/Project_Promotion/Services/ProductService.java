package com.example.Project_Promotion.Services;

import com.example.Project_Promotion.Exception.ResourceNotFoundException;
import com.example.Project_Promotion.Models.Product;
import com.example.Project_Promotion.Repository.ProductRepository;
import com.example.Project_Promotion.dtos.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(p -> new ProductResponseDTO(p.getId(), p.getName(), p.getDescription(), p.getPrice()))
                .collect(Collectors.toList());
    }

    public ProductResponseDTO getProductById(Long productId) {
        Product product = getProductFromRepository(productId);
        return new ProductResponseDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public Product updateProduct(Long productId, Product product) {
        Product existingProduct = getProductFromRepository(productId);
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        // Set other attributes as needed
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    private Product getProductFromRepository(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return (Product) ((Optional<?>) optionalProduct).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
    }
}
