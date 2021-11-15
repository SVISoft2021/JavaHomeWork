package com.pb.sibikovskij.hw7;

public class Atelier {

    static void dressMan(Clothes[] clothes) {
            System.out.println("Пропозиція одягу для чоловіків:");
            for (Clothes clothe : clothes) {
                if (clothe instanceof ManClothes && !(clothe instanceof WomenClothes)) {
                    ((ManClothes) clothe).dressMan();
                    System.out.println(clothe);
                }
                if (clothe instanceof ManClothes && clothe instanceof WomenClothes) {
                    ((ManClothes) clothe).dressManWomen();
                    System.out.println(clothe);
                }
            }
        }

    static void dressWomen(Clothes[] clothes) {
            System.out.println("Пропозиція одягу для жінок:");
            for (Clothes clothe : clothes) {
                if (clothe instanceof WomenClothes && !(clothe instanceof ManClothes)) {
                    ((WomenClothes) clothe).dressWomen();
                    System.out.println(clothe);
                }
                if (clothe instanceof WomenClothes && clothe instanceof ManClothes) {
                    ((WomenClothes) clothe).dressWomenMan();
                    System.out.println(clothe);
                }
            }
        }


    public static void main(String[] args) {

        Size[] sizesOd = Size.values();
        System.out.println("Розміри одягу (довідка): ");
        for (Size sizesOdRozm: sizesOd) {
            System.out.println(sizesOdRozm.toString());
        }

        Clothes[] clothes = {
                new Pants("спортивні", Size.XS, "сірі", "350"),
                new Pants("джинси", Size.M, "сині", "750"),
                new Skirt("вечірня", Size.S, "чорна", "800"),
                new Skirt("літня", Size.M, "рожева", "220"),
                new Tie("бабочка", Size.L, "біла", "100"),
                new Tie("модерн", Size.L, "червоний", "180"),
                new Tshirt("спортивна", Size.M, "біла", "120"),
                new Tshirt("з принтом", Size.L, "кольорова", "200")
        };

        System.out.println("=========================");
        dressMan(clothes);
        System.out.println("=========================");
        dressWomen(clothes);


    }

}
