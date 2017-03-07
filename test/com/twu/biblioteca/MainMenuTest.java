package com.twu.biblioteca;

import com.twu.biblioteca.com.twu.biblioteca.enums.MenuOption;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MainMenuTest {
    @Test
    public void shouldShowListBooksOptionWithoutContactDetails(){
        MainMenu menu = new MainMenu();
        assertEquals("1 - List Books\n" +
                "2 - List Movies\n" +
                "3 - Checkout Item\n" +
                "4 - Return Item\n" +
                "6 - Quit\n", menu.listOptions());
    }
}