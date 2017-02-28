package com.twu.biblioteca;

import org.junit.Test;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by gcampos on 23/02/17.
 */
public class MainMenuTest {
    @Test
    public void shouldShowListBooksOption() throws Exception {
        MainMenu menu = new MainMenu();
        assertEquals("1 - List Books\n" +
                              "2 - Quit", menu.listOptions());
    }

    @Test
    public void shouldBeInvalidOption(){
        MainMenu menu = new MainMenu();
        assertEquals(false, menu.validateUserOptionInput(2));
    }

    @Test
    public void shouldBeValidOption(){
        MainMenu menu = new MainMenu();
        assertEquals(true, menu.validateUserOptionInput(1));
    }

    @Test
    public void shouldCheckOutAvailableBook(){
        MainMenu menu = new MainMenu();
        Book bible = new Book("Bible", "God", 0);
        Book americanGods = new Book("American Gods", "Neil Gaiman", 2001);
        List<Book> books = new ArrayList<>();
        books.add(bible);
        books.add(americanGods);
        Archive archive = new Archive(books);
        assertEquals("Thank you! Enjoy the book", menu.checkoutBook(archive, "American Gods"));
    }

    @Test
    public void shouldReturnErrorMessageWhenCheckingoutBookWithIncorrectBookTitle(){
        MainMenu menu = new MainMenu();
        Book bible = new Book("Bible", "God", 0);
        Book americanGods = new Book("American Gods", "Neil Gaiman", 2001);
        List<Book> books = new ArrayList<>();
        books.add(bible);
        books.add(americanGods);
        Archive archive = new Archive(books);
        assertEquals("That book is not available", menu.checkoutBook(archive, "American Goods"));
    }

    @Test
    public void shouldReturnErrorMessageWhenCheckingOutCheckedOutBook(){
        MainMenu menu = new MainMenu();
        Book bible = new Book("Bible", "God", 0);
        Book americanGods = new Book("American Gods", "Neil Gaiman", 2001);
        List<Book> books = new ArrayList<>();
        bible.checkOut();
        books.add(bible);
        books.add(americanGods);
        Archive archive = new Archive(books);
        assertEquals("That book is not available", menu.checkoutBook(archive, "Bible"));
    }

    @Test
    public void shouldReturnBook(){
        MainMenu menu = new MainMenu();
        Book bible = new Book("Bible", "God", 0);
        Book americanGods = new Book("American Gods", "Neil Gaiman", 2001);
        List<Book> books = new ArrayList<>();
        bible.checkOut();
        books.add(bible);
        books.add(americanGods);
        Archive archive = new Archive(books);
        assertEquals("That book is not available", menu.checkoutBook(archive, "Bible"));
        assertEquals("Thank you for returning the book.", menu.returnBook(archive, "Bible"));
    }

    @Test
    public void shouldReturnSuccessMessageWhenReturningBook(){
        MainMenu menu = new MainMenu();
        Book bible = new Book("Bible", "God", 0);
        Book americanGods = new Book("American Gods", "Neil Gaiman", 2001);
        List<Book> books = new ArrayList<>();
        americanGods.checkOut();
        books.add(bible);
        books.add(americanGods);
        Archive archive = new Archive(books);
        assertEquals("Thank you for returning the book.", menu.returnBook(archive, "American Gods"));
    }

    @Test
    public void shouldReturnErrorMessageWhenReturningBookNotFromTheLibrary(){
        MainMenu menu = new MainMenu();
        Book foundation = new Book("Foundation", "Isaac Asimov", 1951);
        Book americanGods = new Book("American Gods", "Neil Gaiman", 2001);
        List<Book> books = new ArrayList<>();
        books.add(americanGods);
        books.add(foundation);
        Archive archive = new Archive(books);
        assertEquals("That is not a valid book to return.", menu.returnBook(archive, "Bible"));
    }

}