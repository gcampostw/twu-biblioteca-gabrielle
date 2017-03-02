package com.twu.biblioteca;

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
                "5 - Quit\n", menu.listOptions());
    }

    @Test
    public void shouldBeInvalidOption(){
        MainMenu menu = new MainMenu();
        assertEquals(false, menu.validUserOptionInput(9));
    }

    @Test
    public void shouldBeValidOption(){
        MainMenu menu = new MainMenu();
        assertEquals(true, menu.validUserOptionInput(1));
    }

}