package dev.ashish.EcomProductService.exception.ProductController;

import dev.ashish.EcomProductService.controller.ProductController;
import dev.ashish.EcomProductService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ProductController.class)
public class ProductControllerException {
    @ExceptionHandler({ProductNotFoundException.class, NoProductFoundException.class})
    public ResponseEntity productNotFountException(ProductNotFoundException pe) {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(pe.getMessage(), 400);
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }
}
