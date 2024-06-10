package com.helloworld.quickstart.controller.advice;

import com.helloworld.quickstart.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Validation failed HAHA: " + ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

}
