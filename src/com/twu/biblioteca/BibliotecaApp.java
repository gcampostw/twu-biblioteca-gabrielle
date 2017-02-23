package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static String getWelcomeMessage(){
        return "Welcome!";
    }

    public static Archive loadArchive(){
        Book bible = new Book("Bible", "God", 0);
        Book americanGods = new Book("American Gods", "Neil Gaiman", 2001);
        List<Book> books = new ArrayList<>();
        bible.checkOut();
        books.add(bible);
        books.add(americanGods);
        return new Archive(books);
    }
    public static void main(String[] args) {

        Archive archive = loadArchive();
        System.out.println(getWelcomeMessage());
        System.out.println(archive.listBooks());

    }
}
