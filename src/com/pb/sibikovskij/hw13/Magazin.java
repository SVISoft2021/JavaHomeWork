package com.pb.sibikovskij.hw13;

// Магазин, який продає товари
public class Magazin {
    private int product = 0;
    public synchronized void productMinus() {
        while (product < 1) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println("\n= Магазин відкрито, йде торгівля ===============");
        System.out.println("    - > покупець придбав 1 товар");
        System.out.println("      = залишок товару: " + product);
        notify();
    }
    public synchronized void productPlus() {
        while (product >= 3) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println("\n= Магазин закрито, поставка товару ==========");
        System.out.println("  - > постачальник доставив 1 товар");
        System.out.println("    = всього товару: " + product);
        notify();
    }

}
