package com.example.EcommerceSpring.exception;

public class ProductNotFoundException extends RuntimeException {
    // Extending RunTime Exception marks it as unchecked Exception. Callers are Not Forced to use 'throws' to declare or catch it.
    public ProductNotFoundException(String message) {
        super(message);
    }
}