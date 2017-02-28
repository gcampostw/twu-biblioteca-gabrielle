package com.twu.biblioteca;

import exceptions.BookNotFoundException;

import java.util.List;

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

    public String listBooks(){
        String listOfBooks = "Title | Author | Year";
        for (Book book: books) {
            if(!book.isCheckedOut()){
                listOfBooks = String.join("\n", listOfBooks, book.toString());
            }
        }
        return listOfBooks;
    }

    public boolean containsBook(Book book){
        return books.contains(book);

    }

    public Book getBook(Book book) throws BookNotFoundException {
        if(books.indexOf(book) < 0){
            throw new BookNotFoundException();
        }
        return books.get(books.indexOf(book));

    }

    public String checkoutBook(String bookTitle) {
        Book book = new Book(bookTitle, null, 0);
        String checkoutMessage = "That book is not available";
        if(containsBook(book)) {
            Book bookInArchive;
            try {
                bookInArchive = getBook(book);
            } catch (BookNotFoundException e) {
                return checkoutMessage;
            }
            if (!bookInArchive.isCheckedOut()) {
                bookInArchive.checkOut();
                checkoutMessage = "Thank you! Enjoy the book";
            }
        }
        return checkoutMessage;
    }

    public String returnBook(String bookTitle){
        Book book = new Book(bookTitle, null, 0);
        String returnedBook = "That is not a valid book to return.";
        try {
            Book bookInArchive = getBook(book);
            if (bookInArchive.isCheckedOut()) {
                bookInArchive.returnBook();
                returnedBook = "Thank you for returning the book.";
            }
        } catch (BookNotFoundException e) {
            return returnedBook;
        }
        return returnedBook;
    }

}
