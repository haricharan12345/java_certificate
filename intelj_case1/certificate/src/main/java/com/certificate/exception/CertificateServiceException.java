package com.certificate.exception;



public class CertificateServiceException extends RuntimeException {
	public CertificateServiceException(String message) {
        super(message);
    }

    public CertificateServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}









