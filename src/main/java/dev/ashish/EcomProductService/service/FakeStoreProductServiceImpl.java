package dev.ashish.EcomProductService.service;

import dev.ashish.EcomProductService.client.FakeStoreClient;
import dev.ashish.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.ashish.EcomProductService.dto.ProductRequestDTO;
import dev.ashish.EcomProductService.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService{

    @Autowired
    FakeStoreClient fakeStoreClient;
    @Override
    public List<FakeStoreProductResponseDTO> getAllProduct() {
        return fakeStoreClient.getAllProducts();
    }

    @Override
    public FakeStoreProductResponseDTO getProductById(int productId) {
        return null;
    }

    @Override
    public FakeStoreProductResponseDTO updateProduct(int productId, Product updatedProduct) {
        return null;
    }

    @Override
    public boolean deleteProduct(int productId) {
        return false;
    }

    @Override
    public FakeStoreProductResponseDTO createProduct(ProductRequestDTO productRequestDto) {
        return null;
    }
}
