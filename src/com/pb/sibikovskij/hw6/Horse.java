package com.pb.sibikovskij.hw6;

import java.util.Objects;

public class Horse extends Animal{
    public Horse(String name, String poroda, String color, int age, String food, String location) {
        super(name, poroda, color, age, food, location);
    }

    @Override
    public void sleep() {
        super.sleep();
        System.out.println("... точніше не просто відпочиває, а прям хропе");
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
        return "Кінь:\n- ім'я: " + name +
                "\n- порода: " + poroda +
                "\n- колір: " + color +
                "\n- вік: " + age;
    }

    public String AnimalInfo(Horse Horse2) {
        return Horse2.name + " (" + Horse2.poroda + " | " + Horse2.color + ") ["+Horse2.age+" роки]";
    }

    public void Horsequals(Horse Horse2) {
        System.out.println("Порівняємо:\n 1) " + AnimalInfo() +
                "\n 2) "+ AnimalInfo(Horse2)  + "\n Результат - " + equals(Horse2));
    }
}
