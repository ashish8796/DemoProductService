package dev.ashish.EcomProductService.exception.ProductController;

import dev.ashish.EcomProductService.controller.ProductController;
import dev.ashish.EcomProductService.dto.ExceptionResponseDTO;
import dev.ashish.EcomProductService.exception.Common.InvalidRequestException;
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

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity handleInvalidRequestException(InvalidRequestException ex) {
        ExceptionResponseDTO responseDTO = new ExceptionResponseDTO(ex.getMessage(), 400);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
