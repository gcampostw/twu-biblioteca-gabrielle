package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ItemsArchiveTest {

    @Test
    public void shouldPrintListOfTitles(){
        Book bible = new Book("Bible", null, 0);
        List<Book> books = new ArrayList<>();
        books.add(bible);
        ItemsArchive itemsArchive = new ItemsArchive(books);
        assertEquals("| Title | \nBible", itemsArchive.listTitles());
    }

    @Test
    public void shouldPrintListOfBooksWithDetails(){
        Book bible = new Book("Bible", "God", 0);
        Book americanGods = new Book("American Gods", "Neil Gaiman", 2001);
        List<Book> books = new ArrayList<>();
        books.add(bible);
        books.add(americanGods);
        ItemsArchive itemsArchive = new ItemsArchive(books);
        String bookOne = String.join("\n", "Title | Author | Year", "Bible | God | 0",
                "American Gods | Neil Gaiman | 2001");
        assertEquals(bookOne, itemsArchive.listBooks());
    }

    @Test
    public void shouldNotPrintLentBooks(){
        Book bible = new Book("Bible", "God", 0);
        Book americanGods = new Book("American Gods", "Neil Gaiman", 2001);
        List<Book> books = new ArrayList<>();
        bible.checkOut();
        books.add(bible);
        books.add(americanGods);
        ItemsArchive itemsArchive = new ItemsArchive(books);
        String listOfBooks = String.join("\n", "Title | Author | Year", "American Gods | Neil Gaiman | 2001");
        assertEquals(listOfBooks, itemsArchive.listBooks());
    }

    @Test
    public void shouldCheckOutAvailableBook(){
        Book bible = new Book("Bible", "People", 0);
        Book americanGods = new Book("American Gods", "Neil Gaiman", 2001);
        List<Book> books = new ArrayList<>();
        books.add(bible);
        books.add(americanGods);
        ItemsArchive itemsArchive = new ItemsArchive(books);
        assertEquals("Thank you! Enjoy the book", itemsArchive.checkoutItem("American Gods"));
    }

    @Test
    public void shouldReturnErrorMessageWhenCheckingoutBookWithIncorrectBookTitle(){
        Book bible = new Book("Bible", "People", 0);
        Book americanGods = new Book("American Gods", "Neil Gaiman", 2001);
        List<Book> books = new ArrayList<>();
        books.add(bible);
        books.add(americanGods);
        ItemsArchive itemsArchive = new ItemsArchive(books);
        assertEquals("That book is not available", itemsArchive.checkoutItem("American Goods"));
    }

    @Test
    public void shouldReturnErrorMessageWhenCheckingOutCheckedOutBook(){
        Book bible = new Book("Bible", "People", 0);
        Book americanGods = new Book("American Gods", "Neil Gaiman", 2001);
        List<Book> books = new ArrayList<>();
        books.add(bible);
        books.add(americanGods);
        ItemsArchive itemsArchive = new ItemsArchive(books);
        assertEquals("Thank you! Enjoy the book", itemsArchive.checkoutItem("Bible"));
        assertEquals("That book is not available", itemsArchive.checkoutItem("Bible"));
    }

    @Test
    public void shouldReturnSuccessMessageWhenReturningBook(){
        Book bible = new Book("Bible", "God", 0);
        Book americanGods = new Book("American Gods", "Neil Gaiman", 2001);
        List<Book> books = new ArrayList<>();
        books.add(bible);
        books.add(americanGods);
        ItemsArchive itemsArchive = new ItemsArchive(books);
        assertEquals("Thank you! Enjoy the book", itemsArchive.checkoutItem("American Gods"));
        assertEquals("That book is not available", itemsArchive.checkoutItem("American Gods"));
        assertEquals("Thank you for returning the book.", itemsArchive.returnItem("American Gods"));
    }

    @Test
    public void shouldReturnErrorMessageWhenReturningBookNotFromTheLibrary(){
        Book foundation = new Book("Foundation", "Isaac Asimov", 1951);
        Book americanGods = new Book("American Gods", "Neil Gaiman", 2001);
        List<Book> books = new ArrayList<>();
        books.add(americanGods);
        books.add(foundation);
        ItemsArchive itemsArchive = new ItemsArchive(books);
        assertEquals("That book is not available", itemsArchive.checkoutItem("Bible"));
    }

    @Test
    public void shouldListOnlyMovies(){
        Book bible = new Book("Bible", "God", 0);
        Movie titanic = new Movie("Titanic", "James Cameron", 1997, 7);
        Movie avatar = new Movie("Avatar", "James Cameron", 2009, 8);
        List<Book> books = new ArrayList<>();
        books.add(bible);
        books.add(titanic);
        books.add(avatar);
        ItemsArchive itemsArchive = new ItemsArchive(books);
        String bookOne = String.join("\n", "Title | Director | Year | Rating",
                "Titanic | James Cameron | 1997 | 7.0",
                "Avatar | James Cameron | 2009 | 8.0");
        assertEquals(bookOne, itemsArchive.listMovies());
    }

    @Test
    public void shouldNotPrintLentMovies(){
        Movie titanic = new Movie("Titanic", "James Cameron", 1997, 7);
        Movie avatar = new Movie("Avatar", "James Cameron", 2009, 8);
        List<Book> books = new ArrayList<>();
        titanic.checkOut();
        books.add(titanic);
        books.add(avatar);
        ItemsArchive itemsArchive = new ItemsArchive(books);
        String listOfBooks = String.join("\n", "Title | Director | Year | Rating", "Avatar | James Cameron | 2009 | 8.0");
        assertEquals(listOfBooks, itemsArchive.listMovies());
    }

}