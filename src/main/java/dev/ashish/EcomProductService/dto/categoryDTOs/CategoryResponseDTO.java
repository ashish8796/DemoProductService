package dev.ashish.EcomProductService.dto.categoryDTOs;

import dev.ashish.EcomProductService.dto.productDTOs.ProductResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CategoryResponseDTO {
    private UUID categoryID;
    private String categoryName;
    private List<ProductResponseDTO> products;
}
