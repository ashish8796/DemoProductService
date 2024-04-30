package dev.ashish.EcomProductService.exception.Common;

import dev.ashish.EcomProductService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity handleInvalidRequestException (InvalidRequestException ex) {
        ExceptionResponseDTO responseDTO = new ExceptionResponseDTO(ex.getMessage(), 400);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
