package com.getinshape.gis.exceptions;

public class GetInShapeNotFoundException extends RuntimeException {

    public GetInShapeNotFoundException(long id) {
        super("ID: " + id + ", was not found");
    }

    public GetInShapeNotFoundException() {
        super("ID was not found");
    }

    public GetInShapeNotFoundException(String message) {
        super(message);
    }
}
