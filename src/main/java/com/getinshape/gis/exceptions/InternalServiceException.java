package com.getinshape.gis.exceptions;

public class InternalServiceException extends RuntimeException {

    public InternalServiceException(String message) {
        super(message);
    }

    public InternalServiceException(String message, Exception e) {
        super(message, e);

    }
}
