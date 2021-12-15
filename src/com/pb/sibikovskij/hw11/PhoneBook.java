package com.pb.sibikovskij.hw11;

import java.text.ParseException;
import java.util.*;
import java.time.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.exists;

public class PhoneBook {

    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    private List<Client> phoneBookClient = new ArrayList<>();
    private int RowClient;

    public void NewClientTest() throws ParseException {
      phoneBookClient.add(new Client("Петро", LocalDate.parse("2021-10-10"), new String[]{"094-11122233", "067-22233444"}, "Рівне", LocalDateTime.now()));
      phoneBookClient.add(new Client("Степан", LocalDate.parse("1980-04-02"), new String[]{"068-4455678", "067-66666666"}, "Млинів", LocalDateTime.now()));
      phoneBookClient.add(new Client("Кирило", LocalDate.parse("1999-12-03"), new String[]{"094-5452545", "067-88888888"}, "Гоща", LocalDateTime.now()));

      System.out.println("-> 3 абонента в довідник добавлені");
    }

    public void NewClient() {
        try {
            System.out.println("= Запис нового абонента =");
            Scanner txtPole = new Scanner(System.in);

            System.out.print("• ім'я:\n  -> ");
              String namecl = txtPole.nextLine();

            System.out.print("• дата народження в форматі [yyyy-mm-dd]:\n  -> ");
              String birthCl = txtPole.nextLine();
              while (!isValidDate(birthCl)) {
                  System.out.print("\n  -> Помилка !!! Введіть повторно");
                  System.out.print("• дата народження в форматі [yyyy-mm-dd]:\n  -> ");
                  birthCl = txtPole.nextLine();
              }
              LocalDate datebirthCl = LocalDate.parse(birthCl);
              //System.out.println("перевірка = " + String.format("%td/%tm/%tY", datebirthCl,datebirthCl,datebirthCl));

            String[] phoneCl = new String[10];
            System.out.println("• телефони (максимум 10 номерів) [вихід клавіша '#']:");
            System.out.print("  ->");
            String strPhone = txtPole.nextLine();
            int i = 0;
                while (!"#".equals(strPhone)) {
                    phoneCl[i] = strPhone;
                    i++;
                    System.out.print("  ->");
                    strPhone = txtPole.next();
                    }

            System.out.print("• адреса:\n  -> ");
              Scanner txtPoleAdr = new Scanner(System.in);
              String adresCl = txtPoleAdr.nextLine();

            phoneBookClient.add(new Client(namecl, datebirthCl, phoneCl, adresCl, LocalDateTime.now()));
        } catch (Exception e) {
            System.err.println("Помилка при збереженні нового абонента");
        }
        //System.out.println("Клієнт в довідник добавлений:\n -> " + phoneBookClient.toString()+'\n');
        System.out.println("Абонент в довідник добавлений:\n -> " + PhoneClOneTxt(phoneBookClient.size()-1) +'\n');
    }

    public void ListClient() {
        if (phoneBookClient.size() == 0) {
            System.out.println("-> Довідник не заповнений");
        }
        else {
        System.out.println(phoneBookClient);
        }
    }

    public String PhoneClOneTxt(int i) {
        //phoneBookClient.get(i);
        return "Абонент {" +
                "ім'я - " + phoneBookClient.get(i).getNameCl() +
                //", дата народження - " + String.format("%td/%tm/%tY", phoneBookClient.get(i).getBirthCl(),phoneBookClient.get(i).getBirthCl(),phoneBookClient.get(i).getBirthCl()) +
                ", дата народження - " + phoneBookClient.get(i).BirthClT() +
                //", контакти - " + Arrays.toString(PhoneCl) +
                ", контакти - " + phoneBookClient.get(i).PhoneClTxt(phoneBookClient.get(i).getPhoneCl()) +
                ", адреса - " + phoneBookClient.get(i).getAdresCl() +
                ", модифікація - " + phoneBookClient.get(i).getEditCl().toString() +
                "}";
    }

    public void FindClient() {
        System.out.print("Для пошуку введіть повне ім'я абонента:\n-> ");
        Scanner txtPole = new Scanner(System.in);
        String TmpCl = txtPole.nextLine();
        RowClient = -1;

        for (int i = 0; i < phoneBookClient.size(); i++) {
             if (phoneBookClient.get(i).getNameCl().toUpperCase().equals(TmpCl.toUpperCase())) {
                 System.out.println("Абонент [" + TmpCl + "] знайдено в довіднику !\n-> " + PhoneClOneTxt(i));
                 RowClient = i;
                 break;
                }
            }
        if (RowClient == -1) {
            System.out.println("Абонент [" + TmpCl + "] не знайдено в довіднику!");
        }
    }

    public static void EditProg() {
        System.out.println("Редагувати: ");
        System.out.println("1 - ім'я абонента");
        System.out.println("2 - дату народження абонента");
        System.out.println("3 - контакти абонента");
        System.out.println("4 - адресу абонента");
        System.out.println("5 - вихід");
    }

    public void EditClient() throws ParseException {
        FindClient();
        if (RowClient == -1) {return;}
        int RowClientTemp = RowClient;
        EditProg();

        System.out.print("\nВаш вибір -> ");
        Scanner VuborEd = new Scanner(System.in);
        int VuborEdN = VuborEd.nextInt();

        boolean EditVuborInt = true;
        while (EditVuborInt) {
            switch (VuborEdN) {
                case 1:
                    System.out.print("• нове ім'я абонента [" + phoneBookClient.get(RowClientTemp).getNameCl() + "]:\n  -> ");
                    Scanner TxtEd1 = new Scanner(System.in);
                    String nameclnew = TxtEd1.nextLine();
                    phoneBookClient.get(RowClientTemp).setNameCl(nameclnew);
                    phoneBookClient.get(RowClientTemp).setEditCl(LocalDateTime.now());
                    System.out.println("Ім'я абонента успішно змінено!\n-> " + PhoneClOneTxt(RowClientTemp));

                    System.out.println("");
                    EditProg();
                    System.out.print("\nВаш вибір -> ");
                    VuborEdN = VuborEd.nextInt();
                    break;
                case 2:
                    //System.out.print(RowClientTemp);
                    System.out.print("• нова дата народження [" +
                            //String.format("%td/%tm/%tY", phoneBookClient.get(RowClientTemp).0(), phoneBookClient.get(RowClientTemp).getBirthCl(), phoneBookClient.get(RowClientTemp).getBirthCl())
                            phoneBookClient.get(RowClientTemp).BirthClT()
                            + "] в форматі [yyyy-mm-dd]:\n  -> ");
                    Scanner TxtEd2 = new Scanner(System.in);
                    String birthClnew = TxtEd2.nextLine();
                    while (!isValidDate(birthClnew)) {
                        System.out.print("\n  -> Помилка !!! Введіть повторно");
                        System.out.print("• дата народження в форматі [yyyy-mm-dd]:\n  -> ");
                        birthClnew = TxtEd2.nextLine();
                    }
                    //LocalDate datebirthCl = new SimpleDateFormat("yyyy-mm-dd").parse(birthClnew);
                    LocalDate datebirthCl = LocalDate.parse(birthClnew);
                    phoneBookClient.get(RowClientTemp).setBirthCl(datebirthCl);
                    phoneBookClient.get(RowClientTemp).setEditCl(LocalDateTime.now());
                    System.out.println("Дату народження абонента успішно змінено!\n-> " + PhoneClOneTxt(RowClientTemp));

                    System.out.println("");
                    EditProg();
                    System.out.print("\nВаш вибір -> ");
                    VuborEdN = VuborEd.nextInt();
                    break;
                case 3:
                    System.out.print("• нові контакти абонента [" +
                            phoneBookClient.get(RowClientTemp).PhoneClTxt(phoneBookClient.get(RowClientTemp).getPhoneCl()) +
                            "] (максимум 10 номерів) [вихід клавіша '#']:\n");
                    String[] phoneClnew = new String[10];
                    System.out.print("  -> ");
                    Scanner TxtEd3 = new Scanner(System.in);
                    String strPhonenew = TxtEd3.nextLine();
                    int i = 0;
                    while (!"#".equals(strPhonenew)) {
                        phoneClnew[i] = strPhonenew;
                        i++;
                        System.out.print("  -> ");
                        strPhonenew = TxtEd3.next();
                    }
                    phoneBookClient.get(RowClientTemp).setPhoneCl(phoneClnew);
                    phoneBookClient.get(RowClientTemp).setEditCl(LocalDateTime.now());
                    System.out.println("Контакти абонента успішно змінені!\n-> " + PhoneClOneTxt(RowClientTemp));

                    System.out.println("");
                    EditProg();
                    System.out.print("\nВаш вибір -> ");
                    VuborEdN = VuborEd.nextInt();
                    break;
                case 4:
                    System.out.print("• нова адреса абонента [" + phoneBookClient.get(RowClientTemp).getAdresCl() + "]:\n  -> ");
                    Scanner TxtEd4 = new Scanner(System.in);
                    String adresClnew = TxtEd4.nextLine();
                    phoneBookClient.get(RowClientTemp).setAdresCl(adresClnew);
                    phoneBookClient.get(RowClientTemp).setEditCl(LocalDateTime.now());
                    System.out.println("Адреса абонента успішно змінена!\n-> " + PhoneClOneTxt(RowClientTemp));

                    System.out.println("");
                    EditProg();
                    System.out.print("\nВаш вибір -> ");
                    VuborEdN = VuborEd.nextInt();
                    break;
                case 5:
                    RowClient = 0;
                    EditVuborInt = false;
                    break;
                default:
                    System.out.print("Відсутнє меню. Повторіть вибір -> ");
                    VuborEdN = VuborEd.nextInt();
                    break;
            }
        }

    }

    public static void SortProg() {
        System.out.println("Сортувати: ");
        System.out.println("1 - за ім'ям абонентів");
        System.out.println("2 - за датою народження абонентів");
        System.out.println("3 - за адресою абонентів");
        System.out.println("4 - вихід");
    }

    public void SortClient() throws ParseException {
        SortProg();

        System.out.print("\nВаш вибір -> ");
        Scanner VuborEd = new Scanner(System.in);
        int VuborEdN = VuborEd.nextInt();

        boolean EditVuborInt = true;
        while (EditVuborInt) {
            switch (VuborEdN) {
                case 1:
                    Comparator<Client> nameclsort = Comparator.comparing(Client::getNameCl);
                    phoneBookClient.sort(nameclsort);
                    System.out.println("Сортування за іменами успішно проведено!");
                    ListClient();

                    System.out.println("");
                    SortProg();
                    System.out.print("\nВаш вибір -> ");
                    VuborEdN = VuborEd.nextInt();
                    break;
                case 2:
                    Comparator<Client> вirthClsort = Comparator.comparing(Client::getBirthCl);
                    phoneBookClient.sort(вirthClsort);
                    System.out.println("Сортування за датами народження успішно проведено!");
                    ListClient();

                    System.out.println("");
                    SortProg();
                    System.out.print("\nВаш вибір -> ");
                    VuborEdN = VuborEd.nextInt();
                    break;
                case 3:
                    Comparator<Client> adresclsort = Comparator.comparing(Client::getAdresCl);
                    phoneBookClient.sort(adresclsort);
                    System.out.println("Сортування за адресами успішно проведено!");
                    ListClient();

                    System.out.println("");
                    SortProg();
                    System.out.print("\nВаш вибір -> ");
                    VuborEdN = VuborEd.nextInt();
                    break;
                case 4:
                    EditVuborInt = false;
                    break;
                default:
                    System.out.print("Відсутнє меню. Повторіть вибір -> ");
                    VuborEdN = VuborEd.nextInt();
                    break;
            }
        }

    }

    public void DeleteClient() {
        System.out.print("Для видалення введіть повне ім'я абонента:\n-> ");
        Scanner txtPole = new Scanner(System.in);
        String TmpCl = txtPole.nextLine();
        String Um="";

        try {
            for (int i = 0; i < phoneBookClient.size(); i++) {
                if (phoneBookClient.get(i).getNameCl().toUpperCase().equals(TmpCl.toUpperCase())) {
                    System.out.println(PhoneClOneTxt(i) + "\n-> успішно видалений із довідника!");
                    phoneBookClient.remove(i);
                    Um = "Y";
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Помилка при видаленні абонента. Повторіть спробу !");
        }
        if (Um !="Y")
            System.out.println("Абонент [" + TmpCl + "] не знайдено в довіднику!");
    }

    public void SaveClient() {
        try {
            ObjectMapper MapperClient = new ObjectMapper();
             MapperClient.enable(SerializationFeature.INDENT_OUTPUT);
            SimpleModule ClientModule = new SimpleModule();
             ClientModule.addSerializer(LocalDate.class, new LocalDateSerializer());
             ClientModule.addDeserializer(LocalDate.class, new LocalDateDeserializer());
             ClientModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
             ClientModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
            MapperClient.registerModule(ClientModule);

            if (exists(Paths.get("ClientPhoneBookList.json"))) {
                Files.delete(Paths.get("ClientPhoneBookList.json"));}

            Path fileClient = Files.createFile(Paths.get("ClientPhoneBookList.json"));

            String jsonClient = MapperClient.writeValueAsString(phoneBookClient);
            try (BufferedWriter BuffClient = Files.newBufferedWriter(fileClient)) {
                BuffClient.write(jsonClient);
                System.out.println("Телефонний довідник успішно експортовано у файл [" + fileClient + "]");
            }
        } catch (Exception e) {
            System.err.println("При запису файлу виникла помилка. Повторіть спробу");
        }
    }

    public void LoadClient() {
        if (!exists(Paths.get("ClientPhoneBookList.json"))) {
            System.out.println("Телефонного довідника для імпорту не знайдено");
            return;
        }

        try {
            File fileClient = Paths.get("ClientPhoneBookList.json").toFile();
            ObjectMapper MapperClient = new ObjectMapper();
             MapperClient.enable(SerializationFeature.INDENT_OUTPUT);
            SimpleModule ClientModule = new SimpleModule();
             ClientModule.addSerializer(LocalDate.class, new LocalDateSerializer());
             ClientModule.addDeserializer(LocalDate.class, new LocalDateDeserializer());
             ClientModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
             ClientModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
            MapperClient.registerModule(ClientModule);

            List<Client> phoneBookClientTemp = MapperClient.readValue(fileClient, new TypeReference<List<Client>>() {});
            phoneBookClient.addAll(phoneBookClientTemp);
            System.out.println("Телефонний довідник успішно імпортовано !");
        } catch (Exception e) {
            System.err.println("При запису файлу виникла помилка. Повторіть спробу");
        }
    }

}
