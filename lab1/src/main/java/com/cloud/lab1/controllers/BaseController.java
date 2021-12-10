package com.cloud.lab1.controllers;

import javax.naming.NameNotFoundException;
import javax.naming.directory.InvalidAttributeValueException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloud.lab1.dtos.StatusDTO;

@RestControllerAdvice
public class BaseController {


    @ExceptionHandler(Throwable.class)
    public Object manageError(Throwable e) {
        StatusDTO status = new StatusDTO("ERROR", e.getMessage());

        if (e instanceof MethodArgumentNotValidException || e instanceof InvalidAttributeValueException) {
            return ResponseEntity.badRequest().body(status);
        }
        else if (e instanceof NameNotFoundException) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(status);
        } else {
            return ResponseEntity.internalServerError().body(status);
        }
    }
}
