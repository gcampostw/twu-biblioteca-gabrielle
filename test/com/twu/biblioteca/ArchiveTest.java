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
    public void shoudlPrintListOfTitles(){
        Book bible = new Book("Bible");
        List<Book> books = new ArrayList<>();
        books.add(bible);
        Archive archive = new Archive(books);
        assertEquals("| Title | \nBible", archive.listTitles());
    }

}