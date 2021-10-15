package com.pb.sibikovskij.hw2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int operand1;
        int operand2;
        String sign;

        int SignUm;
        double operand1Double,operand2Double;

        // создаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner OperandInt = new Scanner(System.in);

        //======================================================
        System.out.print("Введите первое целое число: ");
        //operand1 = OperandInt.nextInt();

        while (!OperandInt.hasNextInt())
        { // проверяем OperandInt, что бы было целое число, если не целое число то возобновляем ввод
            System.out.println("   "+OperandInt.next() + " - это не целое число");
            System.out.print("Введите первое целое число: ");
        }

        operand1 = OperandInt.nextInt();
        //System.out.println("   первое целое число - " + operand1);

        //======================================================
        System.out.print("Введите второе целое число: ");
        //operand2 = OperandInt.nextInt();

        while (!OperandInt.hasNextInt())
        { // проверяем OperandInt, что бы было целое число, если не целое число то возобновляем ввод
            System.out.println("   "+OperandInt.next() + " - это не целое число");
            System.out.print("Введите второе целое число: ");
        }

        operand2 = OperandInt.nextInt();
        //System.out.println("   второе целое число - " + operand2);


        //======================================================
        System.out.print("Введите знак арифметической операции [ + , - , / , * ]: ");
        sign = OperandInt.next();
        SignUm=sign.indexOf("+")+sign.indexOf("-")+sign.indexOf("/")+sign.indexOf("*");
        //System.out.println("   SignUm = " + SignUm);

        while (SignUm != -3)
        { // проверяем OperandInt, что бы был знаком арифметической операции
            System.out.println("   "+sign + " - это не знак арифметической операции [ + , - , / , * ]");
            System.out.print("Введите знак арифметической операции [ + , - , / , * ]: ");
            sign = OperandInt.next();
            SignUm=sign.indexOf("+")+sign.indexOf("-")+sign.indexOf("/")+sign.indexOf("*");
        }


    //if (sign.indexOf("/") != -1 && operand2 == 0) {
    if (sign.contains("/") && operand2 == 0) {
            System.out.println("   Ошибка !!!\n"+"   "+operand1 + " "+ sign + " "+ operand2 + " = \n"+"   Делить " + operand1 + " на 0 запрещено.\n   Программа буде завершена");
            return;
        }

        System.out.println("");

        switch (sign)
        {
            case "+":
                System.out.println("Результат: " + operand1 + " "+ sign + " "+ operand2 + " = " + (operand1 + operand2));
                break;
            case "-":
                System.out.println("Результат: " + operand1 + " "+ sign + " "+ operand2 + " = " + (operand1 - operand2));
                break;
            case "*":
                System.out.println("Результат: " + operand1 + " "+ sign + " "+ operand2 + " = " + (operand1 * operand2));
                break;
            case "/":
                operand1Double=operand1;
                operand2Double=operand2;
                System.out.println("Результат: " + operand1 + " "+ sign + " "+ operand2 + " = " + String.format("%.2f", operand1Double/operand2Double));
                break;
        }
    }
}
