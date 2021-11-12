package com.pb.sibikovskij.hw6;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class Animal {
    protected String name;
    protected String food;
    protected String location;

    public Animal(String name, String food, String location) {
        this.name = name;
        this.food = food;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String AnimalInfo() {
        return name;
    }
    public String AnimalInfoAll(String AnimalInf) {
        return name + " " + AnimalInf+ " їв " + food + " та гуляв " + location;
    }

    public void makeNoise(String AnimalInf, String locationInf) {
        this.location = locationInf;
        System.out.println(name + " " + AnimalInf + " гуляв " + location);
    }

    public void eat(String AnimalInf, String eatInf) {
        this.food = eatInf;
        System.out.println(name + " " + AnimalInf + " їв " + food);
    }

    public void sleep (String AnimalInf){
        System.out.println(AnimalInf + " спав");
    }


}
