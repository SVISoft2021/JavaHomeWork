package com.pb.sibikovskij.hw7;

public enum Size {
    XXS("XXS"),
    XS("XS"),
    S("S"),
    M("M"),
    L("L");

    private String sizeOdPole;

    Size(String sizeOd) {
        sizeOdPole = sizeOd;
    }

    public String getDescription(String sizeOd){
        String sizeOdtxt = "";
        switch (sizeOd) {
            case "XXS":
                sizeOdtxt = "дитячий розмір (34)";
                break;
            case "XS":
                sizeOdtxt = "підлітковий розмір (36)";
                break;
            case "S":
                sizeOdtxt = "юнацький розмір (38)";
                break;
            case "M":
                sizeOdtxt = "дорослий розмір (40)";
                break;
            case "L":
                sizeOdtxt = "великий розмір (42)";
                break;
        }
        return sizeOdtxt;
    }

    public int getEuroSize(String sizeOd){
        int sizeOdint = 0;
        switch (sizeOd) {
            case "XXS":
                sizeOdint = 32;
                break;
            case "XS":
                sizeOdint = 34;
                break;
            case "S":
                sizeOdint = 36;
                break;
            case "M":
                sizeOdint = 38;
                break;
            case "L":
                sizeOdint = 40;
                break;
        }
        return sizeOdint;
    }

    @Override
    public String toString() {
        return getDescription(sizeOdPole) + " [європейський - " + getEuroSize(sizeOdPole) + "]";
    }



}


