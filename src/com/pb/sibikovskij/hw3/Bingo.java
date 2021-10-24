package com.pb.sibikovskij.hw3;

import java.util.Scanner;
import java.util.Random;

public class Bingo {
    public static void main(String[] args) {
        int variantInt;
        int RandomInt;
        String variantStr;
        String StrUm = "";
        int ColRaz = 0; // Счетчик попыток.

        // создаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner OperandInt = new Scanner(System.in);
        // создаём объект класса Random с лрандомным числом от 0 до 100
        Random RandomPC = new Random();

        //======================================================
        System.out.print("====== Игра Bingo !!!! ======\n== Угадай загаданное число ==\n");
        System.out.print("Я загадал целое число от 0 до 100.\nПопробуй его отгадать )))\n\n");
        System.out.print("P.S. Для досрочного завершения игры нужно ввести символ #\n");
        System.out.print("P.S. Для подсказки нужно ввести символ @\n\n");

        RandomInt = RandomPC.nextInt(101);
        //System.out.println("Подсказка: я загадал число - " + RandomInt);

        //======================================================
        System.out.print("Введи свой вариант: ");
        variantStr = OperandInt.next();

        while (!variantStr.equals(Integer.toString(RandomInt))) {

            if (variantStr.equals("#")) {
                System.out.print("\nЯ понял... Всего " + ColRaz + " попыток и Тебе надоело ???\nА Ты был так близок к победе !!!");
                System.out.println("\nЯ загадал число " + RandomInt + "\nПопробуй меня обыграть в другой раз");
                return;
            }

            if (variantStr.equals("@")) {
               System.out.println("Подсказка: я загадал число - " + RandomInt);
               System.out.print("\nНовый вариант: ");
               variantStr = OperandInt.next();
               continue;
            }

            if(variantStr.matches("-?\\d+(\\.\\d+)?"))
            { // проверяем variantStr, что бы было целое число
                //System.out.println(" - это целое число");
                variantInt=Integer.parseInt(variantStr);
                if (variantInt>RandomInt) {
                    StrUm = "У меня меньше )))";
                } else {
                    StrUm = "У меня больше )))";
                }
            }

            if (!variantStr.equals(Integer.toString(RandomInt))) {
                ColRaz++;
                System.out.println("\nПопытка N" + ColRaz + ": " + variantStr + " - не то, что я загадал. " + StrUm);
                System.out.print("Новый вариант: ");
                variantStr = OperandInt.next();
                //continue;
            }
        }
        ColRaz++;
        System.out.println("\nПоздравляем !!! Ты угадал загаданное число [" + RandomInt + "] с " + ColRaz + " попытки");
    }

}
