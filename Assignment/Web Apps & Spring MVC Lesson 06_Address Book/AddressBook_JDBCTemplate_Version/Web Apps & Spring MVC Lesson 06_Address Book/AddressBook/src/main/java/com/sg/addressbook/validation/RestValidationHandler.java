/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.validation;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author softwareguild
 */
    // Marked with ControllerAdvice for Spring Framework to apply this to our controllers
@ControllerAdvice
public class RestValidationHandler {
    
    // Mark this as an ExceptionHandler and tell it what exceptions it handles
    @ExceptionHandler(MethodArgumentNotValidException.class)
    // Set the HTTP Status reponse code
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    // Mark the return type with @ResponseBody so that the errors are included
    @ResponseBody
    public ValidationErrorContainer processValidationErrors(MethodArgumentNotValidException e){
            // Get the binding result
            BindingResult result = e.getBindingResult();
            List<FieldError> fieldErrors = result.getFieldErrors();

            // Put each validation error into our ValidationErrorContainer
            
            ValidationErrorContainer errors = new ValidationErrorContainer();
            for(FieldError currentError : fieldErrors){
                errors.addValidationError(currentError.getField(), currentError.getDefaultMessage());
            }
            return errors;
    }
    
}













