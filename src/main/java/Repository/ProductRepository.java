package Repository;
// ProductRepository.java

import Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// ProductRepository.java

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    void deleteById(Long id);

    List<Product> findAll();

    Product save(Product product);

    Optional<Product> findById(Long productId);
}
