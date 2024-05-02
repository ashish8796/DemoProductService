package dev.ashish.EcomProductService.service;

import dev.ashish.EcomProductService.dto.categoryDTOs.CategoryRequestDTO;
import dev.ashish.EcomProductService.dto.categoryDTOs.CategoryResponseDTO;
import dev.ashish.EcomProductService.entity.Category;
import dev.ashish.EcomProductService.exception.CategoryController.CategoryNotFoundException;
import dev.ashish.EcomProductService.mapper.CategoryEntityDTOMapper;
import dev.ashish.EcomProductService.respository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        List<Category> categories =  categoryRepository.findAll();
        List<CategoryResponseDTO> responseDTOS = new ArrayList<>();

        for(Category category : categories) {
            responseDTOS.add(CategoryEntityDTOMapper.convertEntityToResponseDTO(category));
        }

        return responseDTOS;
    }

    @Override
    public CategoryResponseDTO getCategoryById(UUID categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new CategoryNotFoundException("Category is not found with id: " + categoryId)
        );

        return CategoryEntityDTOMapper.convertEntityToResponseDTO(category);
    }

    @Override
    public CategoryResponseDTO updateCategoryName(UUID categoryId, CategoryRequestDTO requestDTO) {
        Category existingCategory = categoryRepository.findById(categoryId).orElseThrow(
                () -> new CategoryNotFoundException("Category is not found with id: " + categoryId)
        );

        existingCategory.setName(requestDTO.getCategoryName());

        return CategoryEntityDTOMapper.convertEntityToResponseDTO(categoryRepository.save(existingCategory));
    }

    @Override
    public Boolean deleteCategory(UUID categoryId) {
        categoryRepository.deleteById(categoryId);
        return true;
    }

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO requestDTO) {
        Category category = CategoryEntityDTOMapper.convertRequestDTOtoEntity(requestDTO);
        return CategoryEntityDTOMapper.convertEntityToResponseDTO(categoryRepository.save(category));
    }
}
