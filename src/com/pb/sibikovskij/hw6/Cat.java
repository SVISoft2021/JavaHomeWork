package com.pb.sibikovskij.hw6;

import java.util.Objects;

public class Cat extends Animal{
    private String namesAn;
    private String poroda;
    private String color;
    private int age;

    public Cat(String names, String namesAn, String poroda, String color, int age, String foods, String locations) {
        super(names, foods, locations);
        this.namesAn = namesAn;
        this.poroda = poroda;
        this.color = color;
        this.age = age;
    }

    @Override
    public String AnimalInfo() {
        return super.AnimalInfo()+ " " + namesAn + " (" + poroda + " | " + color + ") ["+age+" роки]";
    }

    @Override
    public String AnimalInfoAll(String AnimalInf) {
        AnimalInf = namesAn + " (" + poroda + " | " + color + ") ["+age+" роки]";
        return super.AnimalInfoAll(AnimalInf);
    }

    @Override
    public void makeNoise(String AnimalInf, String locationInf) {
        AnimalInf = namesAn + " (" + poroda + " | " + color + ") ["+age+" роки]";
        super.makeNoise(AnimalInf, locationInf);
    }

    @Override
    public void eat(String AnimalInf, String eatInf)  {
        AnimalInf = namesAn + " (" + poroda + " | " + color + ") ["+age+" роки]";
        super.eat(AnimalInf, eatInf);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && Objects.equals(namesAn, cat.namesAn) && Objects.equals(poroda, cat.poroda) && Objects.equals(color, cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namesAn, poroda, color, age);
    }

    @Override
    public String toString() {
        return "Кіт {" +
                "кличка ='" + namesAn + '\'' +
                ", порода = '" + poroda + '\'' +
                ", колір = '" + color + '\'' +
                ", вік (років) = " + age + '\'' +
                ", їв = '" + food + '\'' +
                ", гуляв = '" + location + '\'' +
                '}';
    }
}
