package com.pb.sibikovskij.hw10;

import java.util.Arrays;

public class NumBox <T extends Number> {

    // массив из объектов класса T, инициализировать массив в конструкторе
    private final T[] numerics;

    public T get(int i) {
        return numerics[i];
    }

    //конструктор принимающий параметр - максимальную длину массива.
    public NumBox(int AllNumerics) {
        numerics = (T[]) new Number[AllNumerics];
    }

    //метод void add(T num) добавляющий число в массив. В случае если массив полон - выбросить исключение.
    public void add(T MasNumeric) throws ArrayTException {
        String Umova="";
        for (int i = 0; i < numerics.length; i++) {
            if (numerics[i] == null) //если нет значения, тогда присваиваем
                {
                numerics[i] = MasNumeric;
                Umova = "Y";
                break;
                }
            }
        if (Umova=="") {
            throw new ArrayTException("Увага !!! Масив вже повністю заповнений");
        }
    }

    // метод int length() возвращает текущее количество элементов.
    public int lengthMas() {
        int i = 0;
        for (T numericsEl : numerics)
            {
            if (numericsEl != null) {
                i++;
            }
        }
        return i;
    }

    //відображення масиву
    public void MastoString(int lengthMasint) {
        for (int i = 0; i < lengthMasint; i++) {
            if (numerics[i] instanceof Integer) {
                System.out.print("\t" + numerics[i]);
            }
            if (numerics[i] instanceof Float) {
                System.out.print("\t" + String.format("%.4f",numerics[i]));
            }
        }
        System.out.println("");
    }

    //метод double sum() - сумма всех элементов массива.
    public double sum() {
        double sumMas = 0;
        for (T Masnumerics : numerics) {
            if (Masnumerics != null) {
                sumMas += Masnumerics.doubleValue();
            }
        }
        return sumMas;
    }

    //метод double average() - подсчет среднего арифметического среди элементов массива.
    public double average() {
        return this.sum() / this.lengthMas();
    }

    //метод T max() - максимальный элемент массива
    public double max() {
        double maxMas = this.get(0).doubleValue();
        for (T Masnumerics : numerics) {
            if (Masnumerics != null) {
                if (maxMas < Masnumerics.doubleValue()) {
                    maxMas = Masnumerics.doubleValue();
                }
            }
        }
        return maxMas;
    }
}
