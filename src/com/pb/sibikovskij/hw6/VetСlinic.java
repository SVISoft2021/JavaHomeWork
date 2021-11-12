package com.pb.sibikovskij.hw6;

import java.lang.reflect.Constructor;

public class VetСlinic {
    public static void main(String[] args) throws Exception {
        Cat[] Cats = {
                new Cat("кіт", "Барсик", "американський керл", "білий", 3, "-", "-"),
                new Cat("кіт","Васька", "девон-рекс", "сірий", 2, "-", "-"),
                new Cat("кіт","Чорний", "єгипетська мау", "чорний", 5, "-", "-")
        };

        Dog[] Dogs = {
                new Dog("собака","Драко", "uолландський шепендойс", "чорний", 5, "-", "-"),
                new Dog("собака","Димчик", "fвстрійський пінчер", "сіро-рижий", 8, "-", "-"),
                new Dog("собака","Нюхач", "іспанський мастиф", "чорний", 5, "-", "-")
        };

        Horse[] Horses = {
                new Horse("кінь","Блискавка", "перуанський пасо", "чорний", 5, "-", "-"),
                new Horse("кінь","Яблуко", "литовський ваговоз", "сіро-білий", 8, "-", "-"),
                new Horse("кінь","Спалах", "хакне поні", "коричневий", 5, "-", "-")
        };

        Cats[0].makeNoise("", "по дахам");
        Cats[0].eat("", "рибку");

        Cats[1].setFood("консерви");
        Cats[2].setLocation("в парку");

        Dogs[1].setFood("кістку");
        Dogs[0].setLocation("на фут-полі");

        Horses[0].setFood("овес");
        Horses[2].setLocation("на пасовищі");

        System.out.println("\n== Хто спав ==");
        Cats[1].sleep(Cats[1].AnimalInfo());
        Dogs[2].sleep(Dogs[2].AnimalInfo());
        Horses[1].sleep(Horses[1].AnimalInfo());

        System.out.println("\n == Хто їв ==");
        Cats[2].eat("","молоко");
        Dogs[1].eat("","мясо");
        Horses[1].eat("","пшеницю");

        System.out.println("\n == Хто гуляв ==");
        Horses[1].makeNoise("","в полі");
        Cats[0].makeNoise("","на вулиці");
        Dogs[0].makeNoise("","на вулиці");

        Animal[] animalsall = {Cats[0], Cats[1], Cats[2], Dogs[0], Dogs[1], Dogs[2], Horses[0], Horses[1], Horses[2]};

        //В классах Dog, Cat, Horse переопределить методы toString, equals, hashCode.
        System.out.println("\n == Переопределять методы toString, equals, hashCode ==");
        System.out.println("-> "+Cats[1].AnimalInfo()+"\n-> "+Cats[2].AnimalInfo()+"\n= "+Cats[1].equals(Cats[2]));
        System.out.println("-> "+Dogs[0].AnimalInfo()+"\n-> "+Dogs[0].AnimalInfo()+"\n= "+Dogs[0].equals(Dogs[0]));
        System.out.println("-> "+Horses[0].AnimalInfo()+"\n-> "+Horses[1].AnimalInfo()+"\n= "+Horses[0].equals(Horses[1]));

        System.out.println("\n" + Cats[2].AnimalInfo()+"\n- hashCode: " + Cats[2].hashCode());
        System.out.println("\n" + Dogs[2].AnimalInfo()+"\n- hashCode: " + Dogs[2].hashCode());
        System.out.println("\n" + Horses[2].AnimalInfo()+"\n- hashCode: " + Horses[2].hashCode());

        System.out.println("\n"+Cats[2].toString());
        System.out.println("\n"+Dogs[2].toString());
        System.out.println("\n"+Horses[2].toString());


        //VetСlinic -  массив типа Animal, в который запишите животных всех имеющихся у вас типов.
        Class AnimalClass = Class.forName("com.pb.sibikovskij.hw6.Veterinarian");
        // создание объекта через рефлексию
        Class[] paramTypes = new Class[]{String.class};
        Constructor Animalconstr = AnimalClass.getConstructor(paramTypes);
        Object Animalobj = Animalconstr.newInstance("Петров В.С.");
        if (Animalobj instanceof Veterinarian){
            System.out.println("\n== Список до ветеринара ==");
            for (Animal animal : animalsall)
                ((Veterinarian) Animalobj).treatAnimal(animal);
        }
    }

}
