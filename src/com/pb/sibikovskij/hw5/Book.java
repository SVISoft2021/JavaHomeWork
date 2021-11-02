package com.pb.sibikovskij.hw5;

public class Book {
    private String namebook;
    private String autorbook;
    private int yearbook;
    private static int BookCount = 0;


    public Book(String namebook, String autorbook, int yearbook) {
        this.namebook = namebook;
        this.autorbook = autorbook;
        this.yearbook = yearbook;
        BookCount++;
        }

    public static int getBookCount() {
        return BookCount;
    }

    String BookInfo() {
        return autorbook + " \"" + namebook + "\" (" + yearbook + ")";
    }


    public String getNamebook() {
        return namebook;
    }

    public String getAutorbook() {
        return autorbook;
    }

    public int getYearbook() {
        return yearbook;
    }

    public void setNamebook(String namebook) {
        this.namebook = namebook;
    }

    public void setAutorbook(String autorbook) {
        this.autorbook = autorbook;
    }

    public void setYearbook(int yearbook) {
        this.yearbook = yearbook;
    }

}
