package com.pb.sibikovskij.hw8;

public class WrongPasswordException extends Exception {
    private String PassworDetail;

    public WrongPasswordException() {
        PassworDetail = "Некоректний логін";
    }

    public WrongPasswordException(String message) {
        super(message);
        PassworDetail = message;
    }

    @Override
    public String toString() {
        return "Помилка введення паролю: " + PassworDetail;
    }

}
