package com.cba.book.exception;
import java.lang.RuntimeException;

public class CustomBookCatalogueException extends RuntimeException{
    public CustomBookCatalogueException(){

    }
    public CustomBookCatalogueException(String message) {
        super(message);
    }

    public CustomBookCatalogueException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomBookCatalogueException(Throwable cause) {
        super(cause);
    }
}
