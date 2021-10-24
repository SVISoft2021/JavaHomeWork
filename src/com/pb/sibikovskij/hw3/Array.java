package com.pb.sibikovskij.hw3;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        int[] MyArray = new int[5];
        int MyArraySum, MyArrayMinus, MyArrayPlus, MyArrayMinusM, MyArrayPlusM;
        String MyArrayIntString;


        // создаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner OperandMas = new Scanner(System.in);

        //Заполним массив
        for (int i = 0; i < MyArray.length; i++) {
            System.out.print("Введите " + (i+1) + " число массива: ");

            while (!OperandMas.hasNextInt())
            { // проверяем OperandMas, что бы было целое число, если не целое число то возобновляем ввод
                System.out.println("   "+OperandMas.next() + " - это не целое число");
                System.out.print("Введите " + (i+1) + " число массива: ");
                //continue;
            }
            MyArray[i] = OperandMas.nextInt();
        }

        //Выведем массив на экран.
        //MyArrayIntString = Arrays.toString(MyArray);
        //System.out.println("\nЗаполненный масив: " + MyArrayIntString);

        System.out.println("\nЗаполненный масив:");
        for (int i = 0; i < MyArray.length; i++) {
            System.out.println("[" + i + "] = " + MyArray[i]);
        }

        //Статистика по массиву
        MyArraySum = 0;
        MyArrayMinus = 0;
        MyArrayPlus = 0;
        MyArrayMinusM = MyArray[0];
        MyArrayPlusM = MyArray[0];

        //for (int i = 0; i < MyArray.length; i++) {
        for (int j : MyArray) {
            //сумма всех єлементов
            MyArraySum += j;

            //наименьшее число
            if (j < MyArrayMinusM) {
                MyArrayMinusM = j;
            }
            //числа меньше нуля
            if (j < 0) {
                MyArrayMinus++;
            }

            //наибольшее число
            if (j > MyArrayPlusM) {
                MyArrayPlusM = j;
            }

            //числа больше нуля
            if (j > 0) {
                MyArrayPlus++;
            }
        }

        //Вівод статистики по массиву
        System.out.println("\nИнформация о масиве: ");
        System.out.println("====================");
        System.out.println("Всего элементов в массиве = " + MyArray.length);
        System.out.println("из них:");
        if (MyArrayPlus > 0) {
        System.out.println("- положительных - " + MyArrayPlus);}
        if (MyArrayMinus > 0) {
            System.out.println("- отрицательных - " + MyArrayMinus);}

        System.out.println("Общая сумма все элементов массива = " + MyArraySum);
        System.out.println("Наибольшее число = " + MyArrayPlusM);
        System.out.println("Наименьшее число = " + MyArrayMinusM);

        //Отсортируем массив
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < MyArray.length-1; i++) {
                if(MyArray[i] > MyArray[i+1]){
                    isSorted = false;

                    buf = MyArray[i];
                    MyArray[i] = MyArray[i+1];
                    MyArray[i+1] = buf;
                }
            }
        }
        System.out.println("\nОтсортированный масив: ");
        System.out.println("====================");
        MyArrayIntString = Arrays.toString(MyArray);
        System.out.println("Отсортированный масив: " + MyArrayIntString);
        for (int i = 0; i < MyArray.length; i++) {
            System.out.println("[" + i + "] = " + MyArray[i]);
        }
    }
}
