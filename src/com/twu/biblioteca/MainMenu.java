package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

    private final int QUIT_CODE = 4;
    private Archive archive;

    public MainMenu(){
        this.archive = loadArchive();
    }

    public static Archive loadArchive(){
        Book bible = new Book("1984", "George Orwell", 1949);
        Book americanGods = new Book("American Gods", "Neil Gaiman", 2001);
        Book foundation = new Book("Foundation", "Isaac Asimov", 1951);
        Book harryPotter1 = new Book("Harry Potter and the Philosophers Stone", "J. K. Rowling", 1997);
        Book hobbit = new Book("The Hobbit", ". R. R. Tolkien", 1937);
        Book hungerGames = new Book("The Hunger Games", "Suzanne Collins", 2008);

        List<Book> books = new ArrayList<>();
        books.add(bible);
        books.add(americanGods);
        books.add(foundation);
        books.add(harryPotter1);
        books.add(hobbit);
        books.add(hungerGames);
        return new Archive(books);
    }

    public void keepReadingUserInput(){
        Scanner input = new Scanner(System.in);
        int option;
        do{
            printMenuHeader();
            option = input.nextInt();
            processUserChoice(option);
            System.out.println();
        }while(option != QUIT_CODE);

    }

    public void printMenuHeader(){
        System.out.println(listOptions());
        System.out.print("Your option: ");
    }

    public String listOptions(){
        return "1 - List Books\n" +
                "2 - Checkout Book\n" +
                "3 - Return Book\n" +
                "4 - Quit\n";
    }

    public void processUserChoice(int option){
        String message;
        if(validUserOptionInput(option)){
            switch (option){
                case 1:
                    System.out.println(this.archive.listBooks());
                    break;
                case 2:
                    message = this.archive.checkoutBook(getBookChoice());
                    System.out.println(message);
                    break;
                case 3:
                    message = this.archive.returnBook(getBookChoice());
                    System.out.println(message);
                    break;
                case 4:
                    System.out.println("Closing Library Application");
                    break;
            }
        }else{
            System.out.println("Select a valid option!");
        }
    }

    public boolean validUserOptionInput(int option) {
        boolean validOption = true;
        if(option > QUIT_CODE || option < 1){
            validOption = false;
        }
        return validOption;
    }

    public String getBookChoice(){
        Scanner bookInput = new Scanner(System.in);
        String bookTitle;
        System.out.print("Type the book title: ");
        bookTitle = bookInput.nextLine();
        return bookTitle;
    }
}