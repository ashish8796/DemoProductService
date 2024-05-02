package dev.ashish.EcomProductService.service;

import dev.ashish.EcomProductService.dto.productDTOs.ProductRequestDTO;
import dev.ashish.EcomProductService.dto.productDTOs.ProductResponseDTO;
import dev.ashish.EcomProductService.entity.Category;
import dev.ashish.EcomProductService.entity.Product;
import dev.ashish.EcomProductService.exception.CategoryController.CategoryNotFoundException;
import dev.ashish.EcomProductService.exception.ProductController.ProductNotFoundException;
import dev.ashish.EcomProductService.mapper.ProductEntityDTOMapper;
import dev.ashish.EcomProductService.respository.CategoryRepository;
import dev.ashish.EcomProductService.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

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
        Category category = categoryRepository.findById(requestDTO.getCategoryId()).orElseThrow(
                () -> new CategoryNotFoundException("Category is not found with id: " + requestDTO.getCategoryId())
        );

        product.setCategory(category);
        product = productRepository.save(product);

        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);
    }

    public ProductResponseDTO getProductByName(String name) {
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(productRepository.findByTitle(name));
    }

    public List<ProductResponseDTO> getProductsByPriceRange(double minPrice, double maxPrice)
    {
        List<Product> products = productRepository.findByPriceBetween(minPrice, maxPrice);
        List<ProductResponseDTO> responseDTOS = new ArrayList<>();

        for(Product product : products) {
            responseDTOS.add(ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product));
        }

        return responseDTOS;
    }
}
