package dev.ashish.EcomProductService.exception.CartController;

import dev.ashish.EcomProductService.controller.CartController;
import dev.ashish.EcomProductService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = CartController.class)
public class CartControllerException {
    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity handleCartNotFoundException(CartNotFoundException ex) {
        ExceptionResponseDTO responseDTO = new ExceptionResponseDTO(ex.getMessage(), 404);
        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
    }
}
