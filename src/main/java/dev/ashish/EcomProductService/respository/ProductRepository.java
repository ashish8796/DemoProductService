package dev.ashish.EcomProductService.respository;

import dev.ashish.EcomProductService.dto.ProductResponseDTO;
import dev.ashish.EcomProductService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findByTitle(String title);
    Product findFistByTitle(String title);
    List<Product> findByPriceBetween(double minPrice, double maxPrice);
}
