package com.twu.biblioteca;

import java.util.List;

/**
 * Created by gcampos on 23/02/17.
 */
public class Archive {
    private List<Book> books;

    public Archive(List<Book> books){
        this.books = books;
    }

    public String listTitles(){
        String listOfBooks = "| Title | ";
        for (Book book: books) {
            listOfBooks = String.join("\n", listOfBooks, book.getTitle());
        }
        return listOfBooks;
    }

}
