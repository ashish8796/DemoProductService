package dev.ashish.EcomProductService.service;

import dev.ashish.EcomProductService.dto.ProductRequestDTO;
import dev.ashish.EcomProductService.dto.ProductResponseDTO;
import dev.ashish.EcomProductService.entity.Product;
import dev.ashish.EcomProductService.exception.ProductController.ProductNotFoundException;
import dev.ashish.EcomProductService.mapper.ProductEntityDTOMapper;
import dev.ashish.EcomProductService.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<ProductResponseDTO> getAllProduct() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();

        for(Product product : products) {
            productResponseDTOS.add(ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product));
        }

        return productResponseDTOS;
    }

    @Override
    public ProductResponseDTO getProductById(UUID productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("Product is not found for id: " + productId)
        );

        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO updateProduct(UUID productId, ProductRequestDTO requestDTO) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product is not found for id: " + productId));
        product.setTitle(requestDTO.getTitle());
        product.setImageURL(requestDTO.getImageURL());
        product.setPrice(requestDTO.getPrice());
        product.setDescription(requestDTO.getDescription());

        product = productRepository.save(product);
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);
    }

    @Override
    public boolean deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO requestDTO) {
        Product product = ProductEntityDTOMapper.convertProductRequestDTOToEntity(requestDTO);
        product = productRepository.save(product);
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);
    }
}
