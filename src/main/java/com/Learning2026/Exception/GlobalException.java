package com.Learning2026.Exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(CustomerNotFoundException.class)
    ResponseEntity<Response>CustomerNotFoundException(
            CustomerNotFoundException ex,
            HttpServletRequest request
    ){
        Response response=Response.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .error("NotFound")
                .path(request.getContextPath())
                .timeStamp(LocalDateTime.now())

                .build();

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
