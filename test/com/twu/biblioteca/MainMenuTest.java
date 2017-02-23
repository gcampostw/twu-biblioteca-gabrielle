package com.twu.biblioteca;

import org.junit.Test;
import sun.applet.Main;

import static org.junit.Assert.*;

/**
 * Created by gcampos on 23/02/17.
 */
public class MainMenuTest {
    @Test
    public void shouldShowListBooksOption() throws Exception {
        MainMenu menu = new MainMenu();
        assertEquals("1 - List Books\n" +
                              "2 - Quit", menu.listOptions());
    }

    @Test
    public void shouldBeInvalidOption(){
        MainMenu menu = new MainMenu();
        assertEquals(false, menu.validateUserOptionInput(2));
    }

    @Test
    public void shouldBeValidOption(){
        MainMenu menu = new MainMenu();
        assertEquals(true, menu.validateUserOptionInput(1));
    }

}