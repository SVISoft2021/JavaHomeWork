package com.pb.sibikovskij.hw7;

public class Pants extends Clothes implements WomenClothes, ManClothes {
    public Pants(String modelClothes, Size sizesClothes, String colorClothes, String costClothes) {
        super(modelClothes, sizesClothes, colorClothes, costClothes);
    }

    @Override
    public String toString() {
        return "штани {" +
                "модель = " +  getModelClothes() +
                ", розмір = " +getSizesClothes() +
                ", ціна = " + getCostClothes() + " грн" +
                ", колір = " + getColorClothes() +
                "}";
    }

}
