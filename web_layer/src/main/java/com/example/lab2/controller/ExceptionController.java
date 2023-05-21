package com.example.lab2.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class, ConstraintViolationException.class,
            MethodArgumentTypeMismatchException.class, MissingServletRequestParameterException.class})
    public ModelAndView invalidRequest(Exception ex, HttpServletRequest request) {

        ModelAndView result = new ModelAndView("redirect:" + request.getRequestURI());
        result.addObject("error", "Invalid input: " + ex.getMessage());

        return result;
    }
}
