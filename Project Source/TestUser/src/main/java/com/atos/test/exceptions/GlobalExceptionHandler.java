package com.atos.test.exceptions;


import com.atos.test.entities.ApiErrors;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;

/* Created By yassine */

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String message  = "Method Not Supported";
        ApiErrors errors = new ApiErrors(message,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }

    /**
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String message  = "Media Not Supported";
        ApiErrors errors = new ApiErrors(message,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }

    /**
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message  = "Path Variable Missing";
        ApiErrors errors = new ApiErrors(message,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }

    /**
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message  = "Mismatch of type";
        ApiErrors errors = new ApiErrors(message,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }

    /**
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message  = "Request Body Not Readable";
        ApiErrors errors = new ApiErrors(message,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }

    /**
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(UserValidationExistsException.class)
    public ResponseEntity<Object> userValidationException(UserValidationExistsException ex){
        String message  = ex.getMessage();
        ApiErrors errors = new ApiErrors(message,HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);

    }

    /**
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex){
        String message  = "No user found with given id";
        ApiErrors errors = new ApiErrors(message,HttpStatus.NOT_FOUND, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);

    }

    /**
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllOtherException(Exception ex){
        String message  = ex.getMessage();
        ApiErrors errors = new ApiErrors(message,HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);

    }


}
