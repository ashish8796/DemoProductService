package dev.ashish.EcomProductService.exception.Common;

public class InvalidRequestException extends RuntimeException{
    public InvalidRequestException(String message) {
        super(message);
    }
}
