package dev.ashish.EcomProductService.mapper;

import dev.ashish.EcomProductService.dto.productDTOs.ProductResponseDTO;
import dev.ashish.EcomProductService.dto.categoryDTOs.CategoryRequestDTO;
import dev.ashish.EcomProductService.dto.categoryDTOs.CategoryResponseDTO;
import dev.ashish.EcomProductService.entity.Category;
import dev.ashish.EcomProductService.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryEntityDTOMapper {
    public static CategoryResponseDTO convertEntityToResponseDTO(Category category) {
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        
        List<Product> products = category.getProducts();
        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();

        for(Product product : products) {
            productResponseDTOs.add(ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product));
        }

        categoryResponseDTO.setCategoryID(category.getId());
        categoryResponseDTO.setCategoryName(category.getName());
        categoryResponseDTO.setProducts(productResponseDTOs);


        return categoryResponseDTO;
    }

    public static Category convertRequestDTOtoEntity(CategoryRequestDTO requestDTO) {
        Category category = new Category();
        category.setName(requestDTO.getCategoryName());

        return category;
    }
}
