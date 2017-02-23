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
        MainMenu mainMenu = new MainMenu();
        assertEquals("1 - List Books", mainMenu.listOptions());
    }

}