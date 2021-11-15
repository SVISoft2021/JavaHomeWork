package com.pb.sibikovskij.hw7;

public class Skirt extends Clothes implements WomenClothes {
    public Skirt(String modelClothes, Size sizesClothes, String colorClothes, String costClothes) {
        super(modelClothes, sizesClothes, colorClothes, costClothes);
    }

    @Override
    public String toString() {
        return "спідниця {" +
                "модель = " +  getModelClothes() +
                ", розмір = " +getSizesClothes() +
                ", ціна = " + getCostClothes() + " грн" +
                ", колір = " + getColorClothes() +
                "}";
    }
}
