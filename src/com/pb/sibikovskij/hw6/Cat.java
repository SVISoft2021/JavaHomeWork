package com.pb.sibikovskij.hw6;

import java.util.Objects;

public class Cat extends Animal{
    public Cat(String name, String poroda, String color, int age, String food, String location) {
        super(name, poroda, color, age, food, location);
    }


    @Override
    public void makeNoise(String location) {
        super.makeNoise(location);
        System.out.println("... точніше не просто гуляє, а прям гасає");

    }

    @Override
    public String AnimalInfo() {
        return super.AnimalInfo();
    }

    @Override
    public boolean equals(Object Animal_2) {
        if (this == Animal_2)
            return true;
        if (Animal_2 == null || getClass() != Animal_2.getClass())
            return false;
        Animal animals = (Animal) Animal_2;
        return name == animals.name && Objects.equals(poroda, animals.poroda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, poroda, age, color);
    }

    @Override
    public String toString() {
        return "Кіт:\n- ім'я: " + name +
                "\n- порода: " + poroda +
                "\n- колір: " + color +
                "\n- вік: " + age;
    }

    public String AnimalInfo(Cat Cat2) {
        return Cat2.name + " (" + Cat2.poroda + " | " + Cat2.color + ") ["+Cat2.age+" роки]";
    }

    public void Catequals(Cat Cat2) {
        System.out.println("Порівняємо:\n 1) " + AnimalInfo() +
                "\n 2) "+ AnimalInfo(Cat2)  + "\n Результат - " + equals(Cat2));
    }


}
