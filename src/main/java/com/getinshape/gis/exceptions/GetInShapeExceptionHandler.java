package com.getinshape.gis.exceptions;

import com.getinshape.gis.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.persistence.EntityNotFoundException;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GetInShapeExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<ErrorResponse> entityNotFoundException(EntityNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorResponse> handleBindException(BindException ex) {
        String errorsString = ex.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));

        return new ResponseEntity<>(ErrorResponse.builder()
                .message(errorsString)
                .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> generalException(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public final ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public final ResponseEntity<ErrorResponse> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(InternalServiceException.class)
    public final ResponseEntity<ErrorResponse> internalException(InternalServiceException ex){
        return new ResponseEntity<>(ErrorResponse.builder()
                .message(ex.getMessage())
                .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(GetInShapeException.class)
    public final ResponseEntity<ErrorResponse> getInShapeException(GetInShapeException ex) {
        return ResponseEntity.unprocessableEntity().body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(GetInShapeNotFoundException.class)
    public final ResponseEntity<String> getInShapeNotFoundException(GetInShapeNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(BadParametersException.class)
    public final ResponseEntity<ErrorResponse> badParameterException(BadParametersException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage()));
    }
}
