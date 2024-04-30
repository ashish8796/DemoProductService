package dev.ashish.EcomProductService.exception.CartController;

public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(String message) {
        super(message);
    }
}
