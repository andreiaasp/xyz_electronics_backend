package com.example.xyzelectronic.xyz_electronicsbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

public class ProductCategoryNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ProductCategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler (ProductCategoryNotFoundException e){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", e.getMessage());

        return errorMap;
    }
}
