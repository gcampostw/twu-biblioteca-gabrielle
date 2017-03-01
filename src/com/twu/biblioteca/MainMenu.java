package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu {

    private final int QUIT_CODE = 5;
    private ItemsArchive itemsArchive;
    private final UsersArchive usersArchive;
    private User loggedUser = null;

    public MainMenu(){
        this.itemsArchive = new ItemsArchive(null);
        this.usersArchive = new UsersArchive(null);
    }

    public void start(){
        keepLogingInUntilCorrectCredentialsAreEntered();
        keepReadingUserInput();
    }

    private void keepLogingInUntilCorrectCredentialsAreEntered(){
        User user;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Library number: ");
            String userName = input.nextLine();
            System.out.print("Password: ");
            String password = input.nextLine();
            user = login(userName, password);
            if(user==null){
                printWrongLoginCredentialsMessage();
            }
        }while(user == null);

        setLoggedUser(user);
        printLoggedUserInformation();
    }

    private void printWrongLoginCredentialsMessage(){
        System.out.println("----Wrong credentials. Please, try again!----");
    }

    private void printLoggedUserInformation(){
        System.out.println("---------- User Details ----------");
        System.out.println("Name: "+getLoggedUser().getName());
        System.out.println("Email: "+getLoggedUser().getEmail());
        System.out.println("Phone: "+getLoggedUser().getPhoneNumber());
        System.out.println("----------------------------------");
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

    private void printMenuHeader(){
        System.out.println(listOptions());
        System.out.print("Your option: ");
    }

    protected String listOptions(){
        return "1 - List Books\n" +
                "2 - List Movies\n" +
                "3 - Checkout Item\n" +
                "4 - Return Item\n" +
                "5 - Quit\n";
    }

    private void processUserChoice(int option){
        String message;
        if(validUserOptionInput(option)){
            switch (option){
                case 1:
                    System.out.println(this.itemsArchive.listBooks());
                    break;
                case 2:
                    System.out.println(this.itemsArchive.listMovies());
                    break;
                case 3:
                    message = this.itemsArchive.checkoutItem(getItemChoice());
                    System.out.println(message);
                    break;
                case 4:
                    message = this.itemsArchive.returnItem(getItemChoice());
                    System.out.println(message);
                    break;
                case 5:
                    System.out.println("----Closing Library Application----");
                    break;
            }
        }else{
            System.out.println("Select a valid option!");
        }
    }

    protected boolean validUserOptionInput(int option) {
        boolean validOption = true;
        if(option > QUIT_CODE || option < 1){
            validOption = false;
        }
        return validOption;
    }

    private String getItemChoice(){
        Scanner input = new Scanner(System.in);
        System.out.print("Type the book title: ");
        return input.nextLine();
    }

    protected User login(String user, String password) {
        User archivedUser;
        try{
            archivedUser = this.usersArchive.getUser(user);
            if(archivedUser.getPassword().equals(password)){
                archivedUser.login();
            }else{
                archivedUser = null;
            }
        }catch(IndexOutOfBoundsException e){
            archivedUser = null;
        }
        return archivedUser;
    }

    private void setLoggedUser(User user){
        this.loggedUser = user;
    }

    private User getLoggedUser(){
        return this.loggedUser;
    }
}