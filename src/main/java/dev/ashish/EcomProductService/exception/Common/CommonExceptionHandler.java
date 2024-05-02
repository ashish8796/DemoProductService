package dev.ashish.EcomProductService.exception.Common;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class CommonExceptionHandler {
//    @ExceptionHandler(InvalidRequestException.class)
//    public ResponseEntity handleInvalidRequestException (InvalidRequestException ex) {
//        ExceptionResponseDTO responseDTO = new ExceptionResponseDTO(ex.getMessage(), 400);
//        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
//    }
}
