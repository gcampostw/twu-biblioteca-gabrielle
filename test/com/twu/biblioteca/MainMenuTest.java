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
        assertEquals("1 - List Books", menu.listOptions());
    }

    @Test
    public void shouldReturnInvalidOptionMessage(){
        MainMenu menu = new MainMenu();
        assertEquals("Select a valid option!", menu.validateUserOptionInput(2));
    }

    @Test
    public void shouldReturnEmptyMessage(){
        MainMenu menu = new MainMenu();
        assertEquals("", menu.validateUserOptionInput(1));
    }

}