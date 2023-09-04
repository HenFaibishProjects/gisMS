package com.getinshape.gis.exceptions;

public class BadParametersException extends RuntimeException {

    public BadParametersException(String message) {
        super(message);
    }

    public BadParametersException(String message, Exception e) {
        super(message, e);
    }
}
