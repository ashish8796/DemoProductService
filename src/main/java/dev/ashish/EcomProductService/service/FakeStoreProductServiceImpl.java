package dev.ashish.EcomProductService.service;

import dev.ashish.EcomProductService.client.FakeStoreClient;
import dev.ashish.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.ashish.EcomProductService.dto.FakeStoreRequestDTO;
import dev.ashish.EcomProductService.dto.ProductRequestDTO;
import dev.ashish.EcomProductService.dto.ProductResponseDTO;
import dev.ashish.EcomProductService.entity.Product;
import dev.ashish.EcomProductService.exception.Common.InvalidRequestException;
import dev.ashish.EcomProductService.exception.ProductController.NoProductFoundException;
import dev.ashish.EcomProductService.exception.ProductController.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductServiceImpl{

    @Autowired
    FakeStoreClient fakeStoreClient;
   
    public List<FakeStoreProductResponseDTO> getAllProduct() {
        List<FakeStoreProductResponseDTO> products = fakeStoreClient.getAllProducts();

        if(products == null) {
            throw new NoProductFoundException("No products are found");
        }
        return products;
    }

   
    public FakeStoreProductResponseDTO getProductById(int productId) {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreClient.getProductById(productId);
        if(fakeStoreProductResponseDTO == null) {
            throw new ProductNotFoundException("Product is not found with id: " + productId);
        }
        return fakeStoreProductResponseDTO;
    }

   
    public FakeStoreProductResponseDTO updateProduct(int productId, FakeStoreRequestDTO updatedProduct) {
       FakeStoreProductResponseDTO product =  fakeStoreClient.updateProduct(productId, updatedProduct);
       if(productId < 1) {
           throw new InvalidRequestException("Product id is not valid");
       }
       if(product == null) {
           throw new ProductNotFoundException("Product is not found with the id: "+ productId);
       }

       return product;
    }

   
    public boolean deleteProduct(int productId) {
        return fakeStoreClient.deleteProduct(productId);
    }

   
    public FakeStoreProductResponseDTO createProduct(FakeStoreRequestDTO fakeStoreRequestDTO) {
        FakeStoreProductResponseDTO product = fakeStoreClient.createProduct(fakeStoreRequestDTO);
        return product;
    }
}
