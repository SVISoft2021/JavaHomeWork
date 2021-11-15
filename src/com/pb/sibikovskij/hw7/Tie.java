package com.pb.sibikovskij.hw7;

public class Tie extends Clothes implements ManClothes{
    public Tie(String modelClothes, Size sizesClothes, String colorClothes, String costClothes) {
        super(modelClothes, sizesClothes, colorClothes, costClothes);
    }

    @Override
    public String toString() {
        return "краватка {" +
                "модель = " +  getModelClothes() +
                ", розмір = " +getSizesClothes() +
                ", ціна = " + getCostClothes() + " грн" +
                ", колір = " + getColorClothes() +
                "}";
    }
}
