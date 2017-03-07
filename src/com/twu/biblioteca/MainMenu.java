package com.twu.biblioteca;

import com.twu.biblioteca.com.twu.biblioteca.enums.MenuOption;

import java.util.Scanner;

import static com.twu.biblioteca.com.twu.biblioteca.enums.MenuOption.*;

public class MainMenu {

    private ItemsArchive itemsArchive;
    private UsersArchive usersArchive;

    public MainMenu(){
        this.itemsArchive = new ItemsArchive();
        this.usersArchive = new UsersArchive();
    }

    private void login(){
        if(!usersArchive.isUserLogged()){
            System.out.println("You need to login for this operation. Please enter details below.");
            keepLogingInUntilCorrectCredentialsAreEntered();
        }
    }

    private void keepLogingInUntilCorrectCredentialsAreEntered(){
        User user;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Library number: ");
            String userName = input.nextLine();
            System.out.print("Password: ");
            
            String password = input.nextLine();
            user = usersArchive.login(userName, password);
            
            if(user==null){
                printWrongLoginCredentialsMessage();
            }
        }while(user == null);

        usersArchive.setLoggedUser(user);
        System.out.println("----Successful  login. Continue your operation!---");
    }

    private void printWrongLoginCredentialsMessage(){
        System.out.println("----Wrong credentials. Please, try again!----");
    }

    public void keepReadingUserInput(){
        Scanner input = new Scanner(System.in);
        MenuOption option;
        do{
            printMenuHeader();
            option = MenuOption.get(input.nextInt());
            processUserChoice(option);

            System.out.println();
        }while(option != QUIT);
    }

    private void printMenuHeader(){
        System.out.println(listOptions());
        System.out.print("Your option: ");
    }

    protected String listOptions(){
        return MenuOption.listOptions(this.usersArchive.isUserLogged());
    }

    private void processUserChoice(MenuOption option){
        String message = "----Select a valid option!----";
        if(option != null){
            switch (option){
                case LIST_BOOKS:
                   message = this.itemsArchive.listBooks();
                    break;
                case LIST_MOVIES:
                    message = this.itemsArchive.listMovies();
                    break;
                case CHECKOUT_ITEM:
                    login();
                    message = this.itemsArchive.checkoutItem(getItemChoice());
                    break;
                case RETURN_ITEM:
                    login();
                    message = this.itemsArchive.returnItem(getItemChoice());
                    break;
                case QUIT:
                    message = "----Closing Library Application----";
                    break;
                case SHOW_USER_DETAILS:
                    message = usersArchive.getLoggedUserInformation();
            }
        }

        System.out.println(message);
    }

    private String getItemChoice(){
        Scanner input = new Scanner(System.in);
        System.out.print("Type the book title: ");
        return input.nextLine();
    }

}