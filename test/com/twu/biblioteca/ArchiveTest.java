package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by gcampos on 23/02/17.
 */
public class ArchiveTest {

    @Test
    public void shouldPrintListOfTitles(){
        Book bible = new Book("Bible", null, 0);
        List<Book> books = new ArrayList<>();
        books.add(bible);
        Archive archive = new Archive(books);
        assertEquals("| Title | \nBible", archive.listTitles());
    }

    @Test
    public void shouldPrintListOfBooksWithDetails(){
        Book bible = new Book("Bible", "God", 0);
        List<Book> books = new ArrayList<>();
        books.add(bible);
        Archive archive = new Archive(books);
        String bookOne = String.join("\n", "Title | Author | Year", "Bible | God | 0");
        assertEquals(bookOne, archive.listBooks());
    }

    @Test
    public void shouldNotPrintLentBooks(){
        Book bible = new Book("Bible", "God", 0);
        Book americanGods = new Book("American Gods", "Neil Gaiman", 2001);
        List<Book> books = new ArrayList<>();
        bible.checkOut();
        books.add(bible);
        books.add(americanGods);
        Archive archive = new Archive(books);
        String listOfBooks = String.join("\n", "Title | Author | Year", "American Gods | Neil Gaiman | 2001");
        assertEquals(listOfBooks, archive.listBooks());
    }

}