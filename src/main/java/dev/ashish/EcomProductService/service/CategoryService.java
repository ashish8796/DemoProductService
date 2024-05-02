package dev.ashish.EcomProductService.service;

import dev.ashish.EcomProductService.dto.categoryDTOs.CategoryRequestDTO;
import dev.ashish.EcomProductService.dto.categoryDTOs.CategoryResponseDTO;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<CategoryResponseDTO> getAllCategories();
    CategoryResponseDTO getCategoryById(UUID categoryId);
    CategoryResponseDTO updateCategoryName(UUID categoryId, CategoryRequestDTO requestDTO);
    Boolean deleteCategory(UUID categoryId);
    CategoryResponseDTO createCategory(CategoryRequestDTO requestDTO);
}
