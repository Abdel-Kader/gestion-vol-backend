package com.bizao.gestionvol.exceptions;

import com.bizao.gestionvol.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class RestControllerException
{
//    @ExceptionHandler(value = IllegalArgumentException.class)
//    protected ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body(ResponseDTO.builder()
//                        .message(ex.getMessage())
//                        .build()
//                );
//    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ResponseDTO.builder()
                        .message(ex.getMessage())
                        .errorCodes(ex.getErrorCode())
                        .success(Boolean.FALSE)
                        .build()
                );
    }

    @ExceptionHandler(InvalideEntityException.class)
    protected ResponseEntity<Object> handleInvalideEntityExceptionFound(
            InvalideEntityException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseDTO.builder()
                        .message(ex.getMessage())
                        .errorCodes(ex.getErrorCode())
                        .errors(ex.getErrors())
                        .success(Boolean.FALSE)
                        .build()
                );
    }
}
