package com.pb.sibikovskij.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes{
    public Tshirt(String modelClothes, Size sizesClothes, String colorClothes, String costClothes) {
        super(modelClothes, sizesClothes, colorClothes, costClothes);
    }

    @Override
    public String toString() {
        return "футболка {" +
                "модель = " +  getModelClothes() +
                ", розмір = " +getSizesClothes() +
                ", ціна = " + getCostClothes() + " грн" +
                ", колір = " + getColorClothes() +
                "}";
    }
}
