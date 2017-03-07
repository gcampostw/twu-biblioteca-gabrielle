package com.twu.biblioteca.com.twu.biblioteca.enums;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public enum MenuOption {
    LIST_BOOKS(1, "List Books"),
    LIST_MOVIES(2, "List Movies"),
    CHECKOUT_BOOK(3, "Checkout Book"),
    CHECKOUT_MOVIE(4, "Checkout Movie"),
    RETURN_BOOK(5, "Return Book"),
    RETURN_MOVIE(6, "Return Movie"),
    SHOW_USER_DETAILS(7, "Show my details"),
    QUIT(8, "Quit");
    private final int value;
    private final String option;
    private static final Map<Integer, MenuOption> lookup = new HashMap<Integer, MenuOption>();

    static {
        for (MenuOption option : MenuOption.values()) {
            lookup.put(option.getValue(), option);
        }
    }

    MenuOption(int value, String option){
        this.value = value;
        this.option = option;
    }

    public static String listOptions(boolean isUserLoggedIn){
        String options="";
        for (MenuOption option : MenuOption.values()) {
            if(option == SHOW_USER_DETAILS && isUserLoggedIn){
                options += option.getValue() + " - " + option.getOption() + "\n";
            }else if(option != SHOW_USER_DETAILS){
                options += option.getValue() + " - " + option.getOption() + "\n";
            }
        }
        return options;
    }

    public int getValue(){
        return this.value;
    }

    public String getOption(){
        return this.option;
    }

    public static MenuOption get(Integer option) {
        return lookup.get(option);
    }
}

