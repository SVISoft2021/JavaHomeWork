package com.pb.sibikovskij.hw6;

import java.util.Objects;

public class Dog extends Animal {
    public Dog(String name, String poroda, String color, int age, String food, String location) {
        super(name, poroda, color, age, food, location);
    }

    @Override
    public void eat(String food) {
        super.eat(food);
        System.out.println("... точніше не просто їсть, а прям жере її");
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
        return "Собака:\n- ім'я: " + name +
                "\n- порода: " + poroda +
                "\n- колір: " + color +
                "\n- вік: " + age;
    }

    public String AnimalInfo(Dog Dog2) {
        return Dog2.name + " (" + Dog2.poroda + " | " + Dog2.color + ") ["+Dog2.age+" роки]";
    }

    public void Dogequals(Dog Dog2) {
        System.out.println("Порівняємо:\n 1) " + AnimalInfo() +
                "\n 2) "+ AnimalInfo(Dog2)  + "\n Результат - " + equals(Dog2));
    }


}
