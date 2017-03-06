package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu {

    private final int QUIT_CODE = 5;
    private final int LAST_OPTION = 6;
    private ItemsArchive itemsArchive;
    private UsersArchive usersArchive;

    public MainMenu(){
        this.itemsArchive = new ItemsArchive(null);
        this.usersArchive = new UsersArchive(null);
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

    private void printLoggedUserInformation(){
        User user = usersArchive.getLoggedUser();
        System.out.println("---------- User Details ----------");
        System.out.println("Name: "+user.getName());
        System.out.println("Email: "+user.getEmail());
        System.out.println("Phone: "+user.getPhoneNumber());
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
        String defaultMenu ="1 - List Books\n" +
                            "2 - List Movies\n" +
                            "3 - Checkout Item\n" +
                            "4 - Return Item\n" +
                            "5 - Quit\n";

        if(usersArchive.isUserLogged()){
            defaultMenu += "6 - Show my details\n";
        }
        return defaultMenu;
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
                    login();
                    message = this.itemsArchive.checkoutItem(getItemChoice());
                    System.out.println(message);
                    break;
                case 4:
                    login();
                    message = this.itemsArchive.returnItem(getItemChoice());
                    System.out.println(message);
                    break;
                case 5:
                    System.out.println("----Closing Library Application----");
                    break;
                case 6:
                    printLoggedUserInformation();
            }
        }else{
            System.out.println("----Select a valid option!----");
        }
    }

    protected boolean validUserOptionInput(int option) {
        boolean validOption = true;
        if(option > LAST_OPTION || option < 1){
            validOption = false;
        }
        return validOption;
    }

    private String getItemChoice(){
        Scanner input = new Scanner(System.in);
        System.out.print("Type the book title: ");
        return input.nextLine();
    }

}