package com.pb.sibikovskij.hw4;

import java.util.Scanner;

public class Anagram {

    private static String AnagramYN(String TxtN1, String TxtN2) {
        String Rezultat = "";
        String YN = "";

        //убираем из строк спецсимволы и знаки препинания
        TxtN1 =TxtN1.replaceAll("[^a-zA-Zа-яА-Я]", "");
        TxtN2 =TxtN2.replaceAll("[^a-zA-Zа-яА-Я]", "");
        //System.out.println(TxtN1+"\n"+TxtN2);

        for (int i = 0; i < TxtN2.length(); i++) {
                if (TxtN1.toUpperCase().indexOf(TxtN2.toUpperCase().charAt(i)) > 0) {
                    YN += "Y";
                    //System.out.println("Буква [" + i + "] = " + TxtN2.charAt(i) + " - Y");
                }
                if (TxtN1.toUpperCase().indexOf(TxtN2.toUpperCase().charAt(i)) < 0) {
                    YN += "N";
                    //System.out.println("Буква [" + i + "] = " + TxtN2.charAt(i) + " - N");
                }
            }

        //теперь проанализируем полученную YN: если там все Y - тогда второе предложение
        //System.out.println(YN);
        if (YN.indexOf("N")>0)
            Rezultat = "не АНАГРАМА";
        if (YN.indexOf("N")<0)
            Rezultat = "АНАГРАМА";

        return Rezultat;
        }

    public static void main(String[] args) {
        String TxtWord1, TxtWord2;

        // создаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner OperandTxt = new Scanner(System.in);

        System.out.print("Введи предложение: ");
        TxtWord1 = OperandTxt.nextLine();

        System.out.print("Теперь анаграмму этого предложения: ");
        TxtWord2 = OperandTxt.nextLine();

        System.out.print("Результат: второе предложение это " + AnagramYN(TxtWord1, TxtWord2)+" первого");

    }
}
