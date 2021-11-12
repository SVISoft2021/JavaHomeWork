package com.pb.sibikovskij.hw6;

public class Veterinarian {
    private String name;

    public Veterinarian(String name) {
        this.name = name;
    }
    public void treatAnimal(Animal animal) {
        System.out.println("Ветеринар " + name + " оглядає сьогодні " + animal.AnimalInfo() +
                " | " + animal.getName() + " гуляв - " + animal.getLocation() + ", їв - " + animal.getFood());
    }


}
