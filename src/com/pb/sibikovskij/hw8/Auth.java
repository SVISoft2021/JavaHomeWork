package com.pb.sibikovskij.hw8;

public class Auth {
    private static String login = null;
    private static String password = null;
    private static boolean YN = false;

    public Auth() {
    }

    public static String getLogin() {
        return login;
    }

    public static String getPassword() {
        return password;
    }

    public static boolean isYN() {
        return YN;
    }

    public void signUp(String logins, String passwords, String confirmPasswords) throws WrongLoginException, WrongPasswordException {

        if (logins.length() < 5 | logins.length() > 20) {
            throw new WrongLoginException("Помилка введення логіну !\n Логін повинен бути від 5 до 20 символів");
            }
        else if (!logins.matches("[a-zA-Z0-9]+")) {
            throw new WrongLoginException("Помилка введення логіну !\n Логін може включати лише латинські букви та цифри");
            }
            else {
                  this.login = logins;
                  }

        if (passwords.length() < 5) {
            throw new WrongPasswordException("Помилка введення паролю !\n Пароль повинен бути від 5 символів");
        }
        else if (!passwords.matches("[a-zA-Z0-9_]+")) {
            throw new WrongPasswordException("Помилка введення логіну !\n Пароль може включати лише латинські букви та цифри і знак нижнього підкреслювання");
        }
        else {
            this.password = passwords;
        }

        if (!passwords.equals(confirmPasswords)) {
            throw new WrongPasswordException("Помилка перевірки паролю !\n Не правильно підтверджений пароль");
        }
    }

    public void signIn(String logins, String passwords) throws WrongLoginException {
        if (!(this.login.equals(logins)) || !(this.password.equals(passwords))) {
            throw new WrongLoginException("-> некоректний логін або пароль!");
        }
        else {
            YN = true;
        }
    }

}
