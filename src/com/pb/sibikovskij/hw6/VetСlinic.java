package com.pb.sibikovskij.hw6;

import java.lang.reflect.Constructor;

public class VetСlinic extends Animal {

    public VetСlinic(String name, String poroda, String color, int age, String food, String location) {
        super(name, poroda, color, age, food, location);
    }

    @Override
    public String AnimalInfo() {
        return super.AnimalInfo();
    }

    public static void AnimalAll(Animal... animals) {
        for (Animal Alls : animals) {
            System.out.println(Alls.AnimalInfo());
        }
    }

    //public static void main(String[] args) {
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
        Animal[] animalsall = {Cats[0], Cats[1], Cats[2],  Dogs[0], Dogs[1], Dogs[2], Horses[0], Horses[1], Horses[2]};

        System.out.println("\n== Список до ветеринара ==");
        for (Animal Alls : animalsall) {
            System.out.println(Alls.AnimalInfo());
        }

        //System.out.println("\n== Список до ветеринара ==");
        //System.out.println("== котики ==");
        //AnimalAll(Cats);
        //System.out.println("== собачки ==");
        //AnimalAll(Dogs);
        //System.out.println("== коники ==");
        //AnimalAll(Horses);

        Class AnimalClass = Class.forName("com.pb.sibikovskij.hw6.Veterinarian");
        // создание объекта через рефлексию
        Class[] paramTypes = new Class[]{String.class, String.class, String.class, int.class, String.class, String.class};
        Constructor Animalconstr = AnimalClass.getConstructor(paramTypes);
        Object Animalobj = Animalconstr.newInstance("", "", "", 0,"","");
        if (Animalobj instanceof Veterinarian){
            System.out.println("\n== Список до ветеринара ==");
            for (Animal animal : animalsall)
            ((Veterinarian) Animalobj).treatAnimal(animal);
        }

    }
}

