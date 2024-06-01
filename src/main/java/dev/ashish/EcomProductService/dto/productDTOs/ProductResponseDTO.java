package dev.ashish.EcomProductService.dto.productDTOs;

import dev.ashish.EcomProductService.dto.categoryDTOs.CategoryResponseDTO;
import dev.ashish.EcomProductService.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class ProductResponseDTO implements Serializable {
    private UUID productId;
    private String title;
    private double price;
    private String description;
    private CategoryResponseDTO category;
    private String imageURL;
    private double rating;

//    public static ProductResponseDTO from (Product product) {
//        ProductResponseDTO responseDTO = new ProductResponseDTO();
//
//        responseDTO.setProductId(product.getId());
//        responseDTO.setDescription(product.getDescription());
//        responseDTO.setPrice(product.getPrice());
//        responseDTO.setRating(product.getRating());
//        responseDTO.setTitle(product.getTitle());
//        responseDTO.setImageURL(product.getImageURL());
//        responseDTO.setCategory(CategoryResponseDTO.from(product.getCategory()));
//
//        return responseDTO;
//    }
}
