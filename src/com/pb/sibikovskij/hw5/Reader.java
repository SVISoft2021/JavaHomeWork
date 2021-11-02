package com.pb.sibikovskij.hw5;

import java.util.Date;

public class Reader {
    private String student;
    private String dnstudent;
    private String phonestudent;
    private String numberstudent;
    private String facultystudent;
    private String booksadd[];
    private String booksreturn[];
    private int bookscountadd;
    private int bookscountreturn;
    private static int StudentCount = 0;

    public Reader(String student, String dnstudent, String phonestudent, String numberstudent, String facultystudent) {
        this.student = student;
        this.dnstudent = dnstudent;
        this.phonestudent = phonestudent;
        this.numberstudent = numberstudent;
        this.facultystudent = facultystudent;
        this.bookscountadd = 0;
        this.booksadd = new String[100];
        this.bookscountreturn = 0;
        this.booksreturn = new String[100];
        StudentCount++;
    }

    public void StudentAddBooks(String booksname) {
        bookscountadd++;
        booksadd[bookscountadd] = booksname;
        System.out.println(StudentInfo() + "\n взяв з бібліотеки книгу -> " + booksname);
    }

    public static int getStudentCount() {
        return StudentCount;
    }

    public String StudentInfo() {
        return student + " (" + dnstudent + ", " + phonestudent + ") [факультет: " +facultystudent + ", читацький квиток: " + numberstudent+"]";
    }

    public int getStudentBookCountAdd() {
        return this.bookscountadd;
    }

    public int getStudentBookCountReturn() {
        return this.bookscountreturn;
    }

    public int takeBook(){
        return bookscountadd;
        }

    public String takeBookList(){
        String ListBook="";
        for (int i = 1; i <= this.bookscountadd; i++) {
            ListBook = ListBook + "-> " + booksadd[i] + "\n";
        }
        return ListBook;
    }

    public void StudentReturnBooks(String booksname) {
        int YN = 0;
        for (int i = 1; i <= this.bookscountadd; i++) {
            if (booksadd[i].equals(booksname)) {
                YN++;
                bookscountreturn++;
                booksreturn[bookscountreturn] = booksname;
                System.out.println(StudentInfo() + "\n здав книгу -> " + booksname);
                break;
            }
        }
        if (YN < 1) {
            System.out.println(StudentInfo() + "\n Не має такої книги з бібліотеки -> " + booksname);
        }
    }

    public int returnBook(){
       return bookscountreturn;
    }

    public String returnBookList(){
        String ListBook="";
        for (int i = 1; i <= this.bookscountreturn; i++) {
            ListBook = ListBook + "-> " + booksreturn[i] + "\n";
        }
        return ListBook;
    }

}
