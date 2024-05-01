package dev.ashish.EcomProductService.service;

import dev.ashish.EcomProductService.dto.ProductRequestDTO;
import dev.ashish.EcomProductService.dto.ProductResponseDTO;
import dev.ashish.EcomProductService.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<ProductResponseDTO> getAllProduct() {
        return null;
    }

    @Override
    public ProductResponseDTO getProductById(UUID productId) {
        return null;
    }

    @Override
    public ProductResponseDTO updateProduct(UUID productId, ProductRequestDTO updatedProduct) {
        return null;
    }

    @Override
    public boolean deleteProduct(UUID productId) {
        return false;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO fakeStoreRequestDTO) {
        return null;
    }
}
