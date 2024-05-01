package dev.ashish.EcomProductService.controller;

import dev.ashish.EcomProductService.dto.ProductRequestDTO;
import dev.ashish.EcomProductService.dto.ProductResponseDTO;
import dev.ashish.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @GetMapping
    public ResponseEntity getAllProducts() {
        List<ProductResponseDTO> allProducts = productService.getAllProduct();
        return ResponseEntity.ok(allProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable("id") UUID id) {
        ProductResponseDTO product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") UUID id, @RequestBody ProductRequestDTO fakeStoreRequestDTO) {
        ProductResponseDTO product = productService.updateProduct(id, fakeStoreRequestDTO);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") UUID id) {
        boolean isDeleted = productService.deleteProduct(id);
        return ResponseEntity.ok(isDeleted);
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody ProductRequestDTO fakeStoreRequestDTO) {
        ProductResponseDTO product = productService.createProduct(fakeStoreRequestDTO);
        return ResponseEntity.ok(product);
    }
}
