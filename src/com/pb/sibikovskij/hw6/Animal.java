package com.pb.sibikovskij.hw6;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public abstract class Animal {
    //static Cat[] Cats = new Cat[2];
    //static Dog[] Dogs = new Dog[2];
    //static Horse[] Horses = new Horse[2];
    String name;
    String poroda;
    String color;
    int age;
    String food;
    String location;

    public Animal(String name, String poroda, String color, int age, String food, String location) {
        this.name = name;
        this.poroda = poroda;
        this.color = color;
        this.age = age;
        this.food = "-";
        this.location = "-";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoroda() {
        return poroda;
    }

    public void setPoroda(String poroda) {
        this.poroda = poroda;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
        return name + " (" + poroda + " | " + color + ") ["+age+" роки]";
    }

    public void makeNoise(String location) {
        this.location = location;
        System.out.println(this.name + " ("+this.poroda+") ["+this.age+" роки] - наразі гуляє " + this.location );
    }

    public void eat(String food) {
        this.food = food;
        System.out.println(this.name + " ("+this.poroda+") ["+this.age+" роки] - наразі їсть " + this.food);
    }
    public void sleep (){
        System.out.println(this.name + " ("+this.poroda+") ["+this.age+" роки] - наразі відпочиває");
    }

    public static void main(String[] args) throws Exception {
        Cat[] Cats = {
                new Cat("Барсик", "американський керл", "білий", 3, "-","-"),
                new Cat("Васька", "девон-рекс", "сірий", 2, "-","-"),
                new Cat("Чорний", "єгипетська мау", "чорний", 5, "-","-")
        };

        Dog[] Dogs = {
                new Dog("Драко", "uолландський шепендойс", "чорний", 5, "-","-"),
                new Dog("Димчик", "fвстрійський пінчер", "сіро-рижий", 8, "-","-"),
                new Dog("Нюхач", "іспанський мастиф", "чорний", 5, "-","-")
        };

        Horse[] Horses = {
                new Horse("Блискавка", "перуанський пасо", "чорний", 5, "-","-"),
                new Horse("Яблуко", "литовський ваговоз", "сіро-білий", 8, "-","-"),
                new Horse("Спалах", "хакне поні", "коричневий", 5, "-","-")
        };

        System.out.println("== Котики ==");
        for (int i = 0; i <= Cats.length-1; i++) {
            System.out.println((i+1) + ") " + Cats[i].name + " ("+Cats[i].poroda+") ["+Cats[i].age+" роки]");
        }

        System.out.println("== Песики ==");
        for (int i = 0; i <= Dogs.length-1; i++) {
            System.out.println((i+1) + ") " + Dogs[i].name + " ("+Dogs[i].poroda+") ["+Dogs[i].age+" роки]");
        }

        System.out.println("== Коники ==");
        for (int i = 0; i <= Horses.length-1; i++) {
            System.out.println((i+1) + ") " + Horses[i].name + " ("+Horses[i].poroda+") ["+Horses[i].age+" роки]");
        }

        //Метод sleep, например, может выводить на консоль "Такое-то животное спит".
        System.out.println("\n== Хто зараз спить ==");
        Cats[1].sleep();
        Dogs[2].sleep();

        System.out.println("\n == Хто їсть ==");
        Cats[0].eat("рибу");

        System.out.println("\n == Хто гуляє ==");
        Horses[1].makeNoise("в полі");

        //Dog, Cat, Horse переопределяют методы makeNoise, eat.
        System.out.println("\n == Переопределять методы makeNoise, eat ==");
        Cats[1].makeNoise("по деревах");
        Dogs[1].eat("кісточку");
        Horses[0].sleep();

        //В классах Dog, Cat, Horse переопределить методы toString, equals, hashCode.
        System.out.println("\n == Переопределять методы toString, equals, hashCode ==");
        Cats[1].Catequals(Cats[2]);
        Dogs[0].Dogequals(Dogs[0]);
        Horses[1].Horsequals(Horses[2]);

        System.out.println("\n" + Cats[2].AnimalInfo()+"\n- hashCode: " + Cats[2].hashCode());
        System.out.println("\n" + Dogs[2].AnimalInfo()+"\n- hashCode: " + Dogs[2].hashCode());
        System.out.println("\n" + Horses[2].AnimalInfo()+"\n- hashCode: " + Horses[2].hashCode());

        System.out.println("\n"+Cats[2].toString());
        System.out.println("\n"+Dogs[2].toString());
        System.out.println("\n"+Horses[2].toString());

        //Veterinarian - food и location пришедшего на прием животного
        System.out.println("\n== Прийом до ветеринара ==");
        Animal animals = new Veterinarian("","","",0,"","");
        ((Veterinarian)animals).treatAnimal(Cats[0]);
        ((Veterinarian)animals).treatAnimal(Horses[1]);

        //VetСlinic -  массив типа Animal, в который запишите животных всех имеющихся у вас типов.
        System.out.println("\n== Список тварин (ветеринар) ==");
        Animal Allanimals = new VetСlinic("","","",0,"","");
        ((VetСlinic)Allanimals).AnimalAll(Cats);
        ((VetСlinic)Allanimals).AnimalAll(Dogs);
        ((VetСlinic)Allanimals).AnimalAll(Horses);

        Animal[] animalsall = {Cats[0], Cats[1], Cats[2],  Dogs[0], Dogs[1], Dogs[2], Horses[0], Horses[1], Horses[2]};
        Class AnimalClass = Class.forName("com.pb.sibikovskij.hw6.Veterinarian");
        // создание объекта через рефлексию
        Class[] paramTypes = new Class[]{String.class, String.class, String.class, int.class, String.class, String.class};
        Constructor Animalconstr = AnimalClass.getConstructor(paramTypes);
        Object Animalobj = Animalconstr.newInstance("", "", "", 0,"","");
        if (Animalobj instanceof Veterinarian){
            System.out.println("\n== Записали на прийом до ветеринара ==");
            for (Animal animal : animalsall)
                ((Veterinarian) Animalobj).treatAnimal(animal);
        }

    }


}
