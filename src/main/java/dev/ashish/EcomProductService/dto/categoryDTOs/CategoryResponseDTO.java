package dev.ashish.EcomProductService.dto.categoryDTOs;

import dev.ashish.EcomProductService.dto.productDTOs.ProductResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CategoryResponseDTO implements Serializable {
    private UUID categoryID;
    private String categoryName;
    private List<ProductResponseDTO> products;

//    public static CategoryResponseDTO from (Category category) {
//        CategoryResponseDTO responseDTO = new CategoryResponseDTO();
//        responseDTO.setCategoryID(category.getId());
//        responseDTO.setCategoryName(category.getName());
//
//        List<ProductResponseDTO> products = category.getProducts().stream().map(product -> ProductResponseDTO.from(product)).toList();
//        responseDTO.setProducts(products);
//
//        return responseDTO;
//    }
}
