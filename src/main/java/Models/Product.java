package Models;

import javax.persistence.*;


@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;

    public void setId(Long productId) {
    }

    // Other relevant fields

    // Getters and setters
}
