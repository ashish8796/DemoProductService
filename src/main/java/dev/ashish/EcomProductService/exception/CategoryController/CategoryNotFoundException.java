package dev.ashish.EcomProductService.exception.CategoryController;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
