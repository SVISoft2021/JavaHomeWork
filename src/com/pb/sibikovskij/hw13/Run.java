package com.pb.sibikovskij.hw13;

public class Run {
    public static void main(String[] args) {
        Magazin MagazinRun = new Magazin();
        Zavod ZavodRun = new Zavod(MagazinRun);
        Pokupatel PokupatelRun = new Pokupatel(MagazinRun);
        new Thread(ZavodRun).start();
        new Thread(PokupatelRun).start();
    }
}
