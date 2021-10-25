package com.pb.sibikovskij.hw4;

import java.util.Scanner;


public class CapitalLetter {

    static void UpperTXT(String LowTXT) {
        //сделаем масив слов
        String[] LowTXTNew = LowTXT.split(" ");
        String TXtNew;

        // capitalize each word
        for (int i = 0; i < LowTXTNew.length; i++) {
            // учтем момен, если слово будет одной буквой
            if (LowTXTNew[i].length() > 1) {
                LowTXTNew[i] = LowTXTNew[i].substring(0, 1).toUpperCase() + LowTXTNew[i].substring(1).toLowerCase();
            } else {
                LowTXTNew[i] = LowTXTNew[i].substring(0, 1).toUpperCase();
            }
        }

        // соеденим назад масив слов, вставив проблы
        TXtNew = String.join(" ", LowTXTNew);

        System.out.print("Ваше предложение в новом виде: " + TXtNew);
    }

    public static void main(String[] args) {
        String TxtWord;

        // создаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner OperandTxt = new Scanner(System.in);

        System.out.print("Введи предложение: ");
        TxtWord = OperandTxt.nextLine();

        //System.out.println("Ваше предложение: " + TxtWord);
        UpperTXT(TxtWord);
    }
}
