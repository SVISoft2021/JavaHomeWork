package com.pb.sibikovskij.hw12;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class StartN {
    public static void StartProg() {
        System.out.println("= ТЕЛЕФОННИЙ ДОВІДНИК АБОНЕНТІВ v2.0 ===========================");
        System.out.println("0 - добавити 3 абонентів (автомат)");
        System.out.println("1 - добавити абонента");
        System.out.println("2 - знайти абонента");
        System.out.println("3 - редагувати абонента");
        System.out.println("4 - список абонентів");
        System.out.println("5 - сортуванням абонентів");
        System.out.println("6 - видалити абонента");
        System.out.println("7 - запис довідника у файл");
        System.out.println("8 - завантаження довідника із файлу");
        System.out.println("9 - закрити програму");
    }

    public static void main(String[] args) throws ParseException, IOException {
        PhoneBookN phoneBookClient = new PhoneBookN();

        StartProg();

        System.out.print("\nВаш вибір: ");
        Scanner Vubor = new Scanner(System.in);
        int VuborInt = Vubor.nextInt();

        boolean runVuborInt = true;
        while (runVuborInt) {
            switch (VuborInt) {
                case 0:
                    System.out.println("- Абоненти [добавлення записів] ---------------------");
                    phoneBookClient.NewClientTest();
                    System.out.println("");
                    StartProg();
                    System.out.print("\nВаш вибір -> ");
                    VuborInt = Vubor.nextInt();
                    break;
                case 1:
                    System.out.println("- Абоненти [добавлення записів] ---------------------");
                    phoneBookClient.NewClient();
                    System.out.println("");
                    StartProg();
                    System.out.print("\nВаш вибір -> ");
                    VuborInt = Vubor.nextInt();
                    break;
                case 2:
                    System.out.println("- Абоненти [пошук записів] ---------------------");
                    phoneBookClient.FindClientOne();
                    System.out.println("");
                    StartProg();
                    System.out.print("\nВаш вибір -> ");
                    VuborInt = Vubor.nextInt();
                    break;
                case 3:
                    System.out.println("- Абоненти [редагування записів] ---------------------");
                    phoneBookClient.EditClient();
                    System.out.println("");
                    StartProg();
                    System.out.print("\nВаш вибір -> ");
                    VuborInt = Vubor.nextInt();
                    break;
                case 4:
                    System.out.println("- Абоненти [перегляд записів] ---------------------");
                    phoneBookClient.ListClient();
                    System.out.println("");
                    StartProg();
                    System.out.print("\nВаш вибір -> ");
                    VuborInt = Vubor.nextInt();
                    break;
                case 5:
                    System.out.println("- Абоненти [сортування записів] ---------------------");
                    phoneBookClient.SortClient();
                    System.out.println("");
                    StartProg();
                    System.out.print("\nВаш вибір -> ");
                    VuborInt = Vubor.nextInt();
                    break;
                case 6:
                    System.out.println("- Абонент [видалення записів] ---------------------");
                    phoneBookClient.DeleteClient();
                    System.out.println("");
                    StartProg();
                    System.out.print("\nВаш вибір -> ");
                    VuborInt = Vubor.nextInt();
                    break;
                case 7:
                    System.out.println("- Довідник [експорт у файл] ---------------------");
                    phoneBookClient.SaveClient();

                    System.out.println("");
                    StartProg();
                    System.out.print("\nВаш вибір -> ");
                    VuborInt = Vubor.nextInt();
                    break;
                case 8:
                    System.out.println("- Довідник [імпорт із файлу] ---------------------");
                    phoneBookClient.LoadClient();

                    System.out.println("- Абоненти [перегляд записів] ---------------------");
                    phoneBookClient.ListClient();

                    System.out.println("");
                    StartProg();
                    System.out.print("\nВаш вибір -> ");
                    VuborInt = Vubor.nextInt();
                    break;
                case 9:
                    System.exit(0);

                default:
                    System.out.print("Відсутнє меню. Повторіть вибір -> ");
                    VuborInt = Vubor.nextInt();
                    break;
            }
        }
    }
}
