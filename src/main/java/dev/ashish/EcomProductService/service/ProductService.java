package dev.ashish.EcomProductService.service;

import dev.ashish.EcomProductService.dto.FakeStoreRequestDTO;
import dev.ashish.EcomProductService.dto.ProductRequestDTO;
import dev.ashish.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.ashish.EcomProductService.entity.Product;

import java.util.List;

public interface ProductService {
    List<FakeStoreProductResponseDTO> getAllProduct();
    FakeStoreProductResponseDTO getProductById(int productId);
    FakeStoreProductResponseDTO updateProduct(int productId, FakeStoreRequestDTO updatedProduct);
    boolean deleteProduct(int productId);

    FakeStoreProductResponseDTO createProduct(FakeStoreRequestDTO fakeStoreRequestDTO);
}
