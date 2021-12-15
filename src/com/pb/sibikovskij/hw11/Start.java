package com.pb.sibikovskij.hw11;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Start {
    public static void StartProg() {
        System.out.println("= ТЕЛЕФОННИЙ ДОВІДНИК АБОНЕНТІВ ============================");
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
        PhoneBook phoneBookclient = new PhoneBook();

        StartProg();

        System.out.print("\nВаш вибір: ");
        Scanner Vubor = new Scanner(System.in);
        int VuborInt = Vubor.nextInt();

        boolean runVuborInt = true;
        while (runVuborInt) {
            switch (VuborInt) {
             case 0:
                System.out.println("- Абоненти [добавлення записів] ---------------------");
                phoneBookclient.NewClientTest();
                System.out.println("");
                StartProg();
                System.out.print("\nВаш вибір -> ");
                VuborInt = Vubor.nextInt();
                break;
             case 1:
                System.out.println("- Абоненти [добавлення записів] ---------------------");
                phoneBookclient.NewClient();
                System.out.println("");
                StartProg();
                System.out.print("\nВаш вибір -> ");
                VuborInt = Vubor.nextInt();
                break;
             case 2:
                 System.out.println("- Абоненти [пошук записів] ---------------------");
                 phoneBookclient.FindClient();
                 System.out.println("");
                 StartProg();
                 System.out.print("\nВаш вибір -> ");
                 VuborInt = Vubor.nextInt();
                 break;
             case 3:
                 System.out.println("- Абоненти [редагування записів] ---------------------");
                 phoneBookclient.EditClient();
                 System.out.println("");
                 StartProg();
                 System.out.print("\nВаш вибір -> ");
                 VuborInt = Vubor.nextInt();
                 break;
             case 4:
                System.out.println("- Абоненти [перегляд записів] ---------------------");
                phoneBookclient.ListClient();
                System.out.println("");
                StartProg();
                System.out.print("\nВаш вибір -> ");
                VuborInt = Vubor.nextInt();
                break;
             case 5:
                 System.out.println("- Абоненти [сортування записів] ---------------------");
                 phoneBookclient.SortClient();
                 System.out.println("");
                 StartProg();
                 System.out.print("\nВаш вибір -> ");
                 VuborInt = Vubor.nextInt();
                 break;
             case 6:
                System.out.println("- Абонент [видалення записів] ---------------------");
                phoneBookclient.DeleteClient();
                System.out.println("");
                StartProg();
                System.out.print("\nВаш вибір -> ");
                VuborInt = Vubor.nextInt();
                break;
             case 7:
                 System.out.println("- Довідник [експорт у файл] ---------------------");
                 phoneBookclient.SaveClient();

                 System.out.println("");
                 StartProg();
                 System.out.print("\nВаш вибір -> ");
                 VuborInt = Vubor.nextInt();
                 break;
             case 8:
                 System.out.println("- Довідник [імпорт із файлу] ---------------------");
                 phoneBookclient.LoadClient();

                 System.out.println("- Абоненти [перегляд записів] ---------------------");
                 phoneBookclient.ListClient();

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
