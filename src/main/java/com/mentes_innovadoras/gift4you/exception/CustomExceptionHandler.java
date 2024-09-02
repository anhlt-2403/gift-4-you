package com.mentes_innovadoras.gift4you.exception;

import com.mentes_innovadoras.gift4you.exception.core.ArchitectureException;
import com.mentes_innovadoras.gift4you.exception.core.Response.SimpleErrorResponse;
import com.mentes_innovadoras.gift4you.exception.core.Response.ValidationErrorResponse;
import com.mentes_innovadoras.gift4you.constant.ResponseConstant;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ArchitectureException.class)
    public final ResponseEntity<SimpleErrorResponse> handle(ArchitectureException exception) {
        SimpleErrorResponse response = new SimpleErrorResponse(exception);
        return ResponseEntity
                .status(exception.getStatus())
                .body(response);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public final ResponseEntity<SimpleErrorResponse> handleBadCredentialsException(BadCredentialsException exception) {
        SimpleErrorResponse response = new SimpleErrorResponse(exception);
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(response);
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ValidationErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        ValidationErrorResponse response = new ValidationErrorResponse(ResponseConstant.Code.invalidArgument, ResponseConstant.Message.invalidArgument, errors);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }
    @ExceptionHandler(AccessDeniedException.class)
    public final ResponseEntity<SimpleErrorResponse> handleAccessDeniedException(AccessDeniedException exception) {
        SimpleErrorResponse response = new SimpleErrorResponse(exception);
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(response);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ValidationErrorResponse> handleConstraintViolation(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(violation -> {
            String propertyPath = violation.getPropertyPath().toString();
            String errorMessage = violation.getMessage();
            errors.put(propertyPath, errorMessage);
        });
        ValidationErrorResponse response = new ValidationErrorResponse(ResponseConstant.Code.constraintViolation, ResponseConstant.Message.constraintViolation, errors);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }
}
