package dev.ashish.EcomProductService.exception.ProductController;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
