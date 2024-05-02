package dev.ashish.EcomProductService.service;

import dev.ashish.EcomProductService.entity.Category;
import dev.ashish.EcomProductService.entity.Product;
import dev.ashish.EcomProductService.respository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CategoryServiceImplTest {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTotalPriceOfProductUnderCategory() {
        //Arrange
        UUID categoryId = UUID.randomUUID();
        Category categoryMockData = getCategoryMockDataWithProducts();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(categoryMockData));
        double expectedCost = 200.0;

        //Act
        double actualCost = categoryService.getTotalPriceOfCategory(categoryId);

        //Assert
        Assertions.assertEquals(actualCost, expectedCost);
    }

    private Category getCategoryMockDataWithProducts() {
        Category category = new Category();
        category.setName("RandomName");
        category.setId(UUID.randomUUID());

        List<Product> products = new ArrayList<>();

        Product product1 = new Product();
        product1.setTitle("product1");
        product1.setPrice(100.00);
        product1.setCategory(category);

        Product product2 = new Product();
        product2.setTitle("product2");
        product2.setPrice(100.00);
        product2.setCategory(category);

        products.add(product1);
        products.add(product2);

        category.setProducts(products);

        return category;
    }
}
