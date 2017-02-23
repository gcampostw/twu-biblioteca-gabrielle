package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by gcampos on 23/02/17.
 */
public class MainMenu {

    public String listOptions(){
        return "1 - List Books";
    }

    public String validateUserOptionInput(int option) {
        String message = "";
        if(option != 1){
            message = "Select a valid option!";
        }
        return message;
    }

}
