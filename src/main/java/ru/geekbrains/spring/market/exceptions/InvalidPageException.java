package ru.geekbrains.spring.market.exceptions;

public class InvalidPageException extends RuntimeException{
    public InvalidPageException(String msg) {
        super("Invalid page:" + msg);
    }
}
