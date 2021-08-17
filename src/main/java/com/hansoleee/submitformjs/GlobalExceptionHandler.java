package com.hansoleee.submitformjs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseEntity<RestResponse> handlerException(MethodArgumentNotValidException exception) {
        RestResponse restResponse = new RestResponse(false, "유효성 검사 실패 : " + exception.getBindingResult().getAllErrors().get(0).getDefaultMessage());

        return new ResponseEntity<>(restResponse, HttpStatus.BAD_REQUEST);
    }
}
