package ru.geekbrains.spring.market.exceptions;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String msg) {
        super("Product not found:" + msg);
    }
}
