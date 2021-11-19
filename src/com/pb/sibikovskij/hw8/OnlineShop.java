package com.pb.sibikovskij.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {
        String NewLogins = null;
        String NewPasswords = null;
        String NewPasswordsConf = null;

        Auth authNewUser = new Auth();
        Scanner InputTxt = new Scanner(System.in);

        System.out.println("Для здійснення покупок Вам необхідно зареєструватися в нашомуу OnLine-магазині");

        while (authNewUser.getPassword() == null || authNewUser.getLogin() == null) {
            System.out.println("-> придумайте собі логін");
            NewLogins = InputTxt.nextLine();

            System.out.println("-> придумайте пароль");
            NewPasswords = InputTxt.nextLine();

            System.out.println("-> підтвердіть пароль");
            NewPasswordsConf = InputTxt.nextLine();
            try {
            authNewUser.signUp(NewLogins, NewPasswords, NewPasswordsConf);
                }
            catch (WrongLoginException | WrongPasswordException TxtError) {
                System.out.println(TxtError.getMessage());
                }
        }

        while (!NewPasswordsConf.equals(NewPasswords)) {
            System.out.println("-> підтвердіть повторно пароль");
            NewPasswordsConf = InputTxt.nextLine();
            try {
                authNewUser.signUp(NewLogins, NewPasswords, NewPasswordsConf);
            }
            catch (WrongLoginException | WrongPasswordException TxtError) {
                System.out.println(TxtError.getMessage());
            }
        }

        System.out.println();
        System.out.println("Реєстрація пройшла успішно !!!");
        System.out.println("Запам'ятайте свої дані:");
        System.out.println("логін -> "+NewLogins);
        System.out.println("пароль -> "+NewPasswords);
        System.out.println();

        System.out.println("Тепер можете здійснювати покупки в нашому OnLine-магазині !!!");
        System.out.println("Спочатку підтвердіть свю особу:");
        while (!(Auth.isYN())) {
            System.out.println("Введіть Ваш логін");
               String LoginNew = InputTxt.nextLine();
            System.out.println("Введіть Ваш пароль");
               String PassNew = InputTxt.nextLine();
            try {
                authNewUser.signIn(LoginNew, PassNew);
            }
            catch (WrongLoginException TxtError) {
                System.out.println(TxtError.getMessage());
            }
        }

        System.out.println("Ур-а-а-а. Ви в магазині. Швиденько за покупками !!!");

    }


}

