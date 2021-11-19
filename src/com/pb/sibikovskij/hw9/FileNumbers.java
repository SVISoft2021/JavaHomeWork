package com.pb.sibikovskij.hw9;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class FileNumbers {
        public static boolean dividesByTwo(int a){
            return (a%2==0);
        }

        public static void createNumbersFile(String PathFile, int[][] ArrayInt){
        Path PathFileTxt = Paths.get(PathFile);
        try (BufferedWriter WritterTxt = Files.newBufferedWriter(PathFileTxt)) {
            for (int i = 0; i < ArrayInt.length; i++) {
                for (int j = 0; j < ArrayInt[i].length; j++) {
                    WritterTxt.write(ArrayInt[i][j] + "\t");
                }
                //System.out.println();
                WritterTxt.write("\n");
            }
            //for (int valueInt : ArrayInt) {
            //    WritterTxt.write(valueTxt + "\n");
        }
        catch (IOException ErrorTxt) {
            System.out.println("Помилка при запису файла: " + ErrorTxt);
        }
        System.out.println("Файл в папці " + PathFileTxt.toAbsolutePath() + " успішно створено");
    }


    public static void createOddNumbersFile(String PathFile, String OverSave){
        String[] subStrLineTxt;
        String delimeterLineTxt = "\t";
        int[][] ArrayIntNew = new int[10][10];
        int rowArray = 0;

        Path PathFileTxt = Paths.get(PathFile);
        try (BufferedReader ReaderTxt = Files.newBufferedReader(PathFileTxt)) {
            String ReaderMas;
            while((ReaderMas = ReaderTxt.readLine()) != null) {
                //System.out.println(ReaderMas);
                subStrLineTxt = ReaderMas.split(delimeterLineTxt);
                for(int i = 0; i < subStrLineTxt.length; i++) {
                    int tempint = Integer.parseInt(subStrLineTxt[i]);
                    if (dividesByTwo(tempint)) {
                        ArrayIntNew[rowArray][i] = 0;
                    } else {
                    ArrayIntNew[rowArray][i] = tempint;
                    }
                    System.out.print(ArrayIntNew[rowArray][i] + "\t");

                }
                System.out.println("");
                rowArray++;
            }
        } catch (Exception ErrorTxt) {
            System.out.println("Помилка при считуванні файла:  " + ErrorTxt);
        }
        //System.out.println("Файл прочитано");
        if (OverSave.equals("Y")) {
            System.out.println("Запишемо інформацію у новий файл - odd-numbers.txt");
            createNumbersFile("c:\\\\odd-numbers.txt", ArrayIntNew);
        }
    }

    public static void main(String[] args) throws IOException {
        String patchFile;
        int[][] ArrayInt = new int[10][10];
        Random RandomInt = new Random();

        System.out.println("Створимо масив");
        for (int i = 0; i < ArrayInt.length; i++) {
            for (int j = 0; j < ArrayInt[i].length; j++) {
                ArrayInt[i][j] = RandomInt.nextInt(100);
                System.out.print(ArrayInt[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("-------------------------------------------");
        patchFile = "c:\\\\numbers.txt";
        System.out.println("Запишемо цей масив у файл - " + patchFile);
        createNumbersFile(patchFile, ArrayInt);
        System.out.println("-------------------------------------------");
        System.out.println("Прочитаємо файл " + patchFile + " і замінимо в ньому парні числа на 0");
        createOddNumbersFile(patchFile, "Y");
        System.out.println("-------------------------------------------");
        System.out.println("Прочитаємо новий файл c:\\\\odd-numbers.txt");
        createOddNumbersFile("c:\\\\odd-numbers.txt", "N");


    }

}
