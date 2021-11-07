package com.pb.sibikovskij.hw6;

public class Veterinarian extends Animal {
    public Veterinarian(String name, String poroda, String color, int age, String food, String location) {
        super(name, poroda, color, age, food, location);
    }

    public void treatAnimal(Animal Animals) {
       System.out.println(Animals.AnimalInfo()+":\n- сьогодні їв: " + Animals.food +"\n- сьогодні гуляв: "+Animals.location);
       //System.out.println("!@!@!@");
   }

    public void treatAnimalAll(Animal... animals) {
        for (Animal AnimalAll : animals) {
            System.out.println(AnimalAll.AnimalInfo() + ":\n- сьогодні їв: " + AnimalAll.food + "\n- сьогодні гуляв: " + AnimalAll.location);
        }
    }

    public void treatAnimalOne(Animal animalss) {
        System.out.println(animalss.name);

    }


}
