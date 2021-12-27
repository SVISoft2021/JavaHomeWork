package com.pb.sibikovskij.hw13;

// класс Завод, який виробляє товари
public class Zavod implements Runnable {
    Magazin MagazinRun;

    Zavod(Magazin MagazinRun) {
        this.MagazinRun = MagazinRun;
    }

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            MagazinRun.productPlus();
        }
    }
}

