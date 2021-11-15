package com.pb.sibikovskij.hw7;

public interface ManClothes {
    default void dressMan() {
        System.out.print("одяг для чоловіка -> ");
    }
    default void dressManWomen() {
        System.out.print("одяг унісекс -> ");
    }

}
