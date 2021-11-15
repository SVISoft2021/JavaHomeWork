package com.pb.sibikovskij.hw7;

public interface WomenClothes {
    default void dressWomen() {
        System.out.print("одяг для жінок -> ");
    }
    default void dressWomenMan() {
        System.out.print("одяг унісекс -> ");
    }
}
