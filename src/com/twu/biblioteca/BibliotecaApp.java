package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static String getWelcomeMessage(){
        return "Welcome!";
    }

    public static void main(String[] args) {

        System.out.println(getWelcomeMessage());
        MainMenu menu = new MainMenu();
        menu.keepReadingUserInput();
    }
}
