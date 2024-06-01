package dev.ashish.EcomProductService.controller;

import dev.ashish.EcomProductService.dto.productDTOs.ProductRequestDTO;
import dev.ashish.EcomProductService.dto.productDTOs.ProductResponseDTO;
import dev.ashish.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    @Qualifier("ProductService")
    ProductService productService;

    @Cacheable(value = "product")
    @GetMapping
    public List<ProductResponseDTO> getAllProducts() {
        List<ProductResponseDTO> allProducts = productService.getAllProduct();
        System.out.println(allProducts);
        return allProducts;
    }

    @Cacheable(value = "product", key = "#id")
    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(@PathVariable("id") UUID id) {
        System.out.println(id);
        ProductResponseDTO product = productService.getProductById(id);
        return product;
    }

    @CachePut(value = "product", key = "#id")
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable("id") UUID id, @RequestBody ProductRequestDTO fakeStoreRequestDTO) {
        ProductResponseDTO product = productService.updateProduct(id, fakeStoreRequestDTO);
        return ResponseEntity.ok(product);
    }

    @CacheEvict(value = "product", allEntries = true)
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") UUID id) {
        boolean isDeleted = productService.deleteProduct(id);
        return ResponseEntity.ok(isDeleted);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO fakeStoreRequestDTO) {
        ProductResponseDTO product = productService.createProduct(fakeStoreRequestDTO);
        return ResponseEntity.ok(product);
    }
}
