package com.pb.sibikovskij.hw10;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws ArrayTException {
        //иніціюємо масив
        Integer MasSize = 20;
        NumBox<Integer> numericsInt = new NumBox(MasSize);

        System.out.println("== Приклад роботи з масивом з цілих чисел ==================");
        //заповнимо майже весь і покажемо
        Random RandomInt = new Random();
        for (int i = 0; i < 19; i++) {
            numericsInt.add(RandomInt.nextInt(100));
        }
        System.out.print("Масив [19 із " + MasSize + "]:\n->");
        numericsInt.MastoString(numericsInt.lengthMas());

        //добавимо ще 2 елементи
        try {
            System.out.print("Добавим 20 елемент в масив [" + MasSize + "]:\n->");
            numericsInt.add(RandomInt.nextInt(100));
            numericsInt.MastoString(numericsInt.lengthMas());

            System.out.print("Добавим 21 елемент в масив [" + MasSize + "]:\n->");
            numericsInt.add(RandomInt.nextInt(100));

        } catch (ArrayTException errorStr) {
            System.out.println(errorStr.getMessage());
        }


        //число по індексу
        System.out.print("\nЧисло №5 в масиві [" + MasSize + "]:\n->\t");
        System.out.print(numericsInt.get(4));

        //Сума всіх елементів масиву
        System.out.print("\nСума всіх елементів масиву [" + MasSize + "]:\n->\t");
        System.out.print((int)numericsInt.sum());

        //середнє арифметичне
        System.out.print("\nСереднє арифметичне масиву [" + MasSize + "]:\n->\t");
        System.out.print(Double.valueOf(numericsInt.average()));

        //Найбільше значення масиву
        System.out.print("\nНайбільше значення масиву [" + MasSize + "]:\n->\t");
        System.out.print((int)numericsInt.max());


        System.out.print("\n\n== Приклад роботи з масивом з дробових чисел ==================\n");
        NumBox<Float> numericsFloat = new NumBox(MasSize);
        //заповнимо майже весь і покажемо
        Random RandomFloat = new Random();
        for (int i = 0; i < 19; i++) {
            numericsFloat.add(RandomFloat.nextFloat());
        }
        System.out.print("Масив [19 із " + MasSize + "]:\n->");
        numericsFloat.MastoString(numericsFloat.lengthMas());

        //добавимо ще 2 елементи
        try {
            System.out.print("Добавим 20 елемент в масив [" + MasSize + "]:\n->");
            numericsFloat.add(RandomFloat.nextFloat());
            numericsFloat.MastoString(numericsFloat.lengthMas());

            System.out.print("Добавим 21 елемент в масив [" + MasSize + "]:\n->");
            numericsFloat.add(RandomFloat.nextFloat());

        } catch (ArrayTException errorStr) {
            System.out.println(errorStr.getMessage());
        }


        //число по індексу
        System.out.print("\nЧисло №5 в масиві [" + MasSize + "]:\n->\t");
        System.out.print(String.format("%.4f",numericsFloat.get(4)));

        //Сума всіх елементів масиву
        System.out.print("\nСума всіх елементів масиву [" + MasSize + "]:\n->\t");
        System.out.print((float)numericsFloat.sum());

        //середнє арифметичне
        System.out.print("\nСереднє арифметичне масиву [" + MasSize + "]:\n->\t");
        System.out.print((float)numericsFloat.average());

        //Найбільше значення масиву
        System.out.print("\nНайбільше значення масиву [" + MasSize + "]:\n->\t");
        System.out.print((float)numericsFloat.max());


    }

}
