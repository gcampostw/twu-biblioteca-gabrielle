package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by gcampos on 23/02/17.
 */
public class MainMenu {

    private final int QUIT_CODE = 2;

    public String listOptions(){
        return "1 - List Books\n" +
               "2 - Quit";
    }

    public boolean validateUserOptionInput(int option) {
        boolean validOption = true;
        if(option != 1){
            System.out.println("Select a valid option!");
            validOption = false;
        }
        return validOption;
    }

    public void printMenuHeader(){
        System.out.println(listOptions());
        System.out.print("Your option: ");
    }

    public void keepReadingUserInput(){
        Scanner input = new Scanner(System.in);
        printMenuHeader();
        int option = input.nextInt();
        while (option != QUIT_CODE){
            validateUserOptionInput(option);
            printMenuHeader();
            option = input.nextInt();
            System.out.println();
        }
    }

    public String checkoutBook(Archive archive, String bookTitle) {
        Book book = new Book(bookTitle, null, 0);
        String checkoutMessage = "That book is not available";
        if(archive.containsBook(book)) {
            Book bookInArchive = archive.getBook(book);
            if (!bookInArchive.isCheckedOut()) {
                checkoutMessage = "Thank you! Enjoy the book";
            }
        }
        return checkoutMessage;
    }
}
