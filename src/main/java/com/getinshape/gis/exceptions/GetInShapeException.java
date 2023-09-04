package com.getinshape.gis.exceptions;

import java.io.IOException;

public class GetInShapeException extends RuntimeException {
    public GetInShapeException(String msg) {
        super(msg);
    }

    public GetInShapeException(IOException e) {
        super(e);
    }
}
