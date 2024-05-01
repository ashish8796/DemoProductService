package dev.ashish.EcomProductService.service;

import dev.ashish.EcomProductService.dto.ProductRequestDTO;
import dev.ashish.EcomProductService.dto.ProductResponseDTO;
import dev.ashish.EcomProductService.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductResponseDTO> getAllProduct();
    ProductResponseDTO getProductById(UUID productId);
    ProductResponseDTO updateProduct(UUID productId, ProductRequestDTO requestDTO);
    boolean deleteProduct(UUID productId);

    ProductResponseDTO createProduct(ProductRequestDTO requestDTO);
}
