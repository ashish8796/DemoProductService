package dev.ashish.EcomProductService.exception.ProductController;

public class NoProductFoundException extends RuntimeException{
    public NoProductFoundException(String message) {
        super(message);
    }
}
