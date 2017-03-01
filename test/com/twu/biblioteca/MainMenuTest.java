package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MainMenuTest {
    @Test
    public void shouldShowListBooksOption() throws Exception {
        MainMenu menu = new MainMenu();
        assertEquals("1 - List Books\n" +
                "2 - Checkout Book\n" +
                "3 - Return Book\n" +
                "4 - Quit\n", menu.listOptions());
    }

    @Test
    public void shouldBeInvalidOption(){
        MainMenu menu = new MainMenu();
        assertEquals(false, menu.validUserOptionInput(6));
    }

    @Test
    public void shouldBeValidOption(){
        MainMenu menu = new MainMenu();
        assertEquals(true, menu.validUserOptionInput(1));
    }

    @Test
    public void userShouldLogin(){
        MainMenu menu = new MainMenu();
        assertNotNull(menu.login("111-1111", "password1"));

    }

    @Test
    public void userShouldBeLoggedIn(){
        MainMenu menu = new MainMenu();
        User loggedUser = menu.login("222-2222", "password2");
        assertNotNull(loggedUser);
        assertTrue(loggedUser.isLoggedIn());
    }
}