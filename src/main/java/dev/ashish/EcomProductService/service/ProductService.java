package dev.ashish.EcomProductService.service;

import dev.ashish.EcomProductService.dto.ProductRequestDTO;
import dev.ashish.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.ashish.EcomProductService.entity.Product;

import java.util.List;

public interface ProductService {
    List<FakeStoreProductResponseDTO> getAllProduct();
    FakeStoreProductResponseDTO getProductById(int productId);
    FakeStoreProductResponseDTO updateProduct(int productId, Product updatedProduct);
    boolean deleteProduct(int productId);

    FakeStoreProductResponseDTO createProduct(ProductRequestDTO productRequestDto);
}
