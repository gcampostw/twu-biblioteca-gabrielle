package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

    private final int QUIT_CODE = 5;
    private ItensArchive itensArchive;
    private final UsersArchive usersArchive;
    private User logedUser = null;

    public MainMenu(){
        this.itensArchive = loadArchive();
        this.usersArchive = loadUsers();
    }

    public static ItensArchive loadArchive(){
        Book bible = new Book("1984", "George Orwell", 1949);
        Book americanGods = new Book("American Gods", "Neil Gaiman", 2001);
        Book foundation = new Book("Foundation", "Isaac Asimov", 1951);
        Book harryPotter1 = new Book("Harry Potter and the Philosophers Stone", "J. K. Rowling", 1997);
        Book hobbit = new Book("The Hobbit", ". R. R. Tolkien", 1937);
        Book hungerGames = new Book("The Hunger Games", "Suzanne Collins", 2008);

        Movie titanic = new Movie("Titanic", "James Cameron", 1997, 7.7);
        Movie avatar = new Movie("Avatar", "James Cameron", 2009, 7.8);
        Movie moonlight = new Movie("Moonlight", "Barry Jenkins", 2017, 7.8);
        Movie laland = new Movie("La La Land", "Damien Chazelle", 2017, 8.5);
        Movie lion = new Movie("Lion", "Garth Davis", 2017, 8);

        List<Book> itens = new ArrayList<>();
        itens.add(bible);
        itens.add(americanGods);
        itens.add(foundation);
        itens.add(harryPotter1);
        itens.add(hobbit);
        itens.add(hungerGames);

        itens.add(titanic);
        itens.add(avatar);
        itens.add(moonlight);
        itens.add(laland);
        itens.add(lion);

        return new ItensArchive(itens);
    }

    private static UsersArchive loadUsers(){
        User user1 = new User("111-1111","password1", "User Number 1",
                "usernbm1@gmail.com", "81981889999");
        User user2 = new User("222-2222","password2", "User Number 2",
                "usernbm2@gmail.com", "81982889999");
        User user3 = new User("333-3333","password3", "User Number 3",
                "usernbm1@gmail.com", "81983889999");
        User user4 = new User("444-4444","password4", "User Number 4",
                "usernbm1@gmail.com", "81984889999");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        return new UsersArchive(users);
    }

    public void start(){
        keepLogingInUntilCorrectCredentialsAreEntered();
        keepReadingUserInput();
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

    public void printLoggedUserInformation(){
        System.out.println("---------- User Details ----------");
        System.out.println("Name: "+getLoggedUser().getName());
        System.out.println("Email: "+getLoggedUser().getEmail());
        System.out.println("Phone: "+getLoggedUser().getPhoneNumber());
        System.out.println("----------------------------------");
    }

    public String listOptions(){
        return "1 - List Books\n" +
                "2 - List Movies\n" +
                "3 - Checkout Item\n" +
                "4 - Return Item\n" +
                "5 - Quit\n";
    }

    public void processUserChoice(int option){
        String message;
        if(validUserOptionInput(option)){
            switch (option){
                case 1:
                    System.out.println(this.itensArchive.listBooks());
                    break;
                case 2:
                    System.out.println(this.itensArchive.listMovies());
                    break;
                case 3:
                    message = this.itensArchive.checkoutItem(getBookChoice());
                    System.out.println(message);
                    break;
                case 4:
                    message = this.itensArchive.returnItem(getBookChoice());
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

    public void keepLogingInUntilCorrectCredentialsAreEntered(){
        User user = null;
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

        setLogedUser(user);
        printLoggedUserInformation();
    }

    public void printWrongLoginCredentialsMessage(){
        System.out.println("----Wrong credentials. Please, try again!----");
    }

    public User login(String user, String password) {
        User archivedUser = null;
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

    public void setLogedUser(User user){
        this.logedUser = user;
    }

    public User getLoggedUser(){
        return this.logedUser;
    }
}