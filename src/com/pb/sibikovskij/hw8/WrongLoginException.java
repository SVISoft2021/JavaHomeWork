package com.pb.sibikovskij.hw8;

public class WrongLoginException extends Exception {
    private String LoginDetail;

    public WrongLoginException() {
        LoginDetail = "Некоректний логін";
    }

    public WrongLoginException(String message) {
        super(message);
        LoginDetail = message;
    }

    @Override
    public String toString() {
        return "Помилка введення логіну: " + LoginDetail;
    }

}
