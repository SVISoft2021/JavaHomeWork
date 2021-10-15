package com.pb.sibikovskij.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        int operand;

        // создаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner OperandInt = new Scanner(System.in);

        //======================================================
        System.out.print("Введите любое целое число: ");
        //operand = OperandInt.nextInt();

        while (!OperandInt.hasNextInt()) { // проверяем OperandInt, что бы было целое число, если не целое число то возобновляем ввод
            System.out.println("   " + OperandInt.next() + " - это не целое число");
            System.out.print("Введите любое целое число: ");
        }

        operand = OperandInt.nextInt();
        //System.out.println("   целое число - " + operand);

        if (operand>=0 && operand<=14) {
            System.out.println("   введенное число " + operand + " попадает в промежуток [0-14]");
        } else
            if (operand>14 && operand<=35) {
                System.out.println("   введенное число " + operand + " попадает в промежуток [15-35]");
            } else
                if (operand>35 && operand<=50) {
                    System.out.println("   введенное число " + operand + " попадает в промежуток [35-50]");
                } else
                    if (operand>50 && operand<=100) {
                        System.out.println("   введенное число " + operand + " попадает в промежуток [51-100]");
                    } else {
                        System.out.println("   введенное число " + operand + " НЕ попадает в промежуток [0-100]");
                    }


    }
}
