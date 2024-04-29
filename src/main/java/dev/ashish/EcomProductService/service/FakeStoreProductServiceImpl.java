package dev.ashish.EcomProductService.service;

import dev.ashish.EcomProductService.client.FakeStoreClient;
import dev.ashish.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.ashish.EcomProductService.dto.FakeStoreRequestDTO;
import dev.ashish.EcomProductService.dto.ProductRequestDTO;
import dev.ashish.EcomProductService.dto.ProductResponseDTO;
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
        return fakeStoreClient.getProductById(productId);
    }

    @Override
    public FakeStoreProductResponseDTO updateProduct(int productId, FakeStoreRequestDTO updatedProduct) {
        return fakeStoreClient.updateProduct(productId, updatedProduct);
    }

    @Override
    public boolean deleteProduct(int productId) {
        return fakeStoreClient.deleteProduct(productId);
    }

    @Override
    public FakeStoreProductResponseDTO createProduct(FakeStoreRequestDTO fakeStoreRequestDTO) {
        FakeStoreProductResponseDTO product = fakeStoreClient.createProduct(fakeStoreRequestDTO);
        return product;
    }
}
