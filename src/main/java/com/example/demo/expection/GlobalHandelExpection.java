package com.example.demo.expection;

import com.example.demo.payload.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalHandelExpection {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<String> resourceNotFound(
            ResourceNotFound r
//            WebRequest request
    ) {
//        ErrorDto errorDto = new ErrorDto(r.getMessage(), new Date(), request.getDescription(true));
        return new ResponseEntity<>(r.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handelGlobalException(
            Exception e
    ) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
