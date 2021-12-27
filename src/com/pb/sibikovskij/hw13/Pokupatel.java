package com.pb.sibikovskij.hw13;

public class Pokupatel implements Runnable {
    Magazin MagazinRun;

    Pokupatel(Magazin MagazinRun){
        this.MagazinRun = MagazinRun;
    }
    @Override
    public void run(){
        for (int i = 1; i < 5; i++) {
            MagazinRun.productMinus();
        }

    }
}
