package com.certificate.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class CustomExceptionGetAll {
	
	@ExceptionHandler(CertificateNotFoundException.class)
    public ResponseEntity<String> handleCertificateServiceException1(CertificateNotFoundException ex) {
        // You can customize the response message and HTTP status code here
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }


}

