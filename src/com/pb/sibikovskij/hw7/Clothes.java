package com.pb.sibikovskij.hw7;

public abstract class Clothes {
    private String modelClothes;
    private Size sizesClothes;
    private String ColorClothes;
    private String CostClothes;

    public Clothes(String modelClothes, Size sizesClothes, String colorClothes, String costClothes) {
        this.modelClothes = modelClothes;
        this.sizesClothes = sizesClothes;
        ColorClothes = colorClothes;
        CostClothes = costClothes;
    }

    public String getModelClothes() {
        return modelClothes;
    }

    public void setModelClothes(String modelClothes) {
        this.modelClothes = modelClothes;
    }

    public Size getSizesClothes() {
        return sizesClothes;
    }

    public void setSizesClothes(Size sizesClothes) {
        this.sizesClothes = sizesClothes;
    }

    public String getColorClothes() {
        return ColorClothes;
    }

    public void setColorClothes(String colorClothes) {
        ColorClothes = colorClothes;
    }

    public String getCostClothes() {
        return CostClothes;
    }

    public void setCostClothes(String costClothes) {
        CostClothes = costClothes;
    }
}
