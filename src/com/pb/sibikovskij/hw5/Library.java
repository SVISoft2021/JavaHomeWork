package com.pb.sibikovskij.hw5;


public class Library {

    public static void main(String[] args) {
        //===КНИГИ============================================================
        Book book1 = new Book("Ромео і Джульєтта", "Вільям Шекспір", 1999);
        Book book2 = new Book("Маленький принц", "Антуан де Сент Екзюпері", 1995);
        Book book3 = new Book("Енеїда", "Іван Котляревський", 2010);
        Book book4 = new Book("Тарас Бульба", "Микола Гоголь", 2000);
        Book book5 = new Book("", "", 1900);
        Book book6 = new Book("", "", 1900);

        book5.setNamebook("Пігмаліон");
        book5.setAutorbook("Бернард Шоу");
        book5.setYearbook(2001);

        book6.setNamebook("Собаче серце");
        book6.setAutorbook("Михайло Булгаков");
        book6.setYearbook(2015);

        Book[] books = {book1, book2, book3, book4, book5, book6};
        System.out.println("= Список книг в бібліотеці ==================");
        for (int i = 1; i <= Book.getBookCount(); i++) {
            System.out.println(i + ") " + books[i - 1].BookInfo());
        }
        System.out.println("Всього книг - " + Book.getBookCount());

        System.out.println("");
        //====СТУДЕНТЫ========================================================
        Reader stud1 = new Reader("Давидюк С.І.", "01.10.1980", "+380973254789", "54848", "Аграрні науки та продовольство / Агроінженерія");
        Reader stud2 = new Reader("Моцеглов Ю.О.", "12.12.1983", "+380956553455", "82383", "Сфера обслуговування / Готельно-ресторанна справа");
        Reader stud3 = new Reader("Домащук В.В.", "25.02.1980", "+380684547237", "45461", "Математика та статистика / Прикладна математика");
        Reader stud4 = new Reader("Хруницький Е.І.", "02.03.1981", "+380665454723", "56561", "Цивільна безпека / Цивільна безпека / Охорона праці");

        Reader[] students = {stud1, stud2, stud3, stud4};
        System.out.println("= Список студентів =======================");
        for (int i = 1; i <= Reader.getStudentCount(); i++) {
            System.out.println(i + ") " + students[i - 1].StudentInfo());
        }
        System.out.println("Всього студентів - " + Reader.getStudentCount());


        System.out.println("");
        //====ПОЛУЧЕНИЕ КНИГ==================================================
        students[0].StudentAddBooks(books[1].BookInfo());
        students[0].StudentAddBooks(books[4].BookInfo());
        students[1].StudentAddBooks(books[5].BookInfo());
        students[2].StudentAddBooks(books[3].BookInfo());
        students[3].StudentAddBooks(books[4].BookInfo());
        students[3].StudentAddBooks(books[2].BookInfo());

        System.out.println("");
        //====КНИГИ НА РУКАХ==================================================
        System.out.println("Книги на руках:");
        for (int i = 1; i <= Reader.getStudentCount(); i++) {
            if (students[i-1].takeBook()>0)
            System.out.println(students[i-1].takeBook()+" -> "+students[i-1].StudentInfo());
        }

        System.out.println("");
        //====КНИГИ НА РУКАХ СПИСОК==================================================
        System.out.println("Книги на руках (список):");
        for (int i = 1; i <= Reader.getStudentCount(); i++) {
            if (students[i-1].takeBook()>0)
             System.out.println(students[i-1].StudentInfo() + ":\n" + students[i-1].takeBookList());
        }

        System.out.println("");
        //====ПОВЕРНЕННЯ КНИГ==================================================
        students[0].StudentReturnBooks(books[1].BookInfo());
        students[0].StudentReturnBooks(books[5].BookInfo());
        students[1].StudentReturnBooks(books[2].BookInfo());
        students[3].StudentReturnBooks(books[2].BookInfo());


        System.out.println("");
        //====ЗДАНІ КНИГИ==================================================
        System.out.println("Прочитані книги:");
        for (int i = 1; i <= Reader.getStudentCount(); i++) {
            if (students[i-1].returnBook()>0)
                System.out.println(students[i-1].returnBook()+" -> "+students[i-1].StudentInfo());
        }

        System.out.println("");
        //====ЗДАНІ КНИГИ СПИСОК==================================================
        System.out.println("Прочитані книги (список):");
        for (int i = 1; i <= Reader.getStudentCount(); i++) {
            if (students[i-1].returnBook()>0)
                System.out.println(students[i-1].StudentInfo() + ":\n" + students[i-1].returnBookList());
        }


    }
}

//int countbook=0;
//for (Book bookslist: books) {
//    countbook++;
//    System.out.println(countbook+") " + bookslist.BookInfo());
//}
