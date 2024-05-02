package dev.ashish.EcomProductService.mapper;

import dev.ashish.EcomProductService.dto.productDTOs.ProductRequestDTO;
import dev.ashish.EcomProductService.dto.productDTOs.ProductResponseDTO;
import dev.ashish.EcomProductService.entity.Product;

public class ProductEntityDTOMapper {
    public static ProductResponseDTO convertProductEntityToProductResponseDTO (Product product) {
        ProductResponseDTO responseDTO = new ProductResponseDTO();

        responseDTO.setProductId(product.getId());
        responseDTO.setTitle(product.getTitle());
        responseDTO.setCategory(product.getCategory());
        responseDTO.setRating(product.getRating());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setImageURL(product.getImageURL());
        responseDTO.setDescription(product.getDescription());

        return responseDTO;
    }

    public static Product convertProductRequestDTOToEntity(ProductRequestDTO requestDTO) {
        Product product = new Product();

        product.setImageURL(requestDTO.getImageURL());
        product.setTitle(requestDTO.getTitle());
        product.setDescription(requestDTO.getDescription());
        product.setPrice(requestDTO.getPrice());
        product.setRating(requestDTO.getRating());

        return product;
    }
}
