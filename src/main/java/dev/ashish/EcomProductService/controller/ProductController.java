package dev.ashish.EcomProductService.controller;

import dev.ashish.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.ashish.EcomProductService.dto.FakeStoreRequestDTO;
import dev.ashish.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity getAllProducts() {
        List<FakeStoreProductResponseDTO> allProducts = productService.getAllProduct();
        return ResponseEntity.ok(allProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable("id") int id) {
        FakeStoreProductResponseDTO product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") int id, @RequestBody FakeStoreRequestDTO fakeStoreRequestDTO) {
        System.out.println(id);
        System.out.println(fakeStoreRequestDTO.toString());
        FakeStoreProductResponseDTO product = productService.updateProduct(id, fakeStoreRequestDTO);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") int id) {
        boolean isDeleted = productService.deleteProduct(id);
        return ResponseEntity.ok(isDeleted);
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody FakeStoreRequestDTO fakeStoreRequestDTO) {
        FakeStoreProductResponseDTO product = productService.createProduct(fakeStoreRequestDTO);
        return ResponseEntity.ok(product);
    }
}
