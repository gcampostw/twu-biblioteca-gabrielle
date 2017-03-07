package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by gcampos on 01/03/17.
 */
public class UsersArchiveTest {

    @Test
    public void userShouldLogin(){
        UsersArchive archive = new UsersArchive();
        assertNotNull(archive.login("111-1111", "password1"));
    }

    @Test
    public void userShouldBeLoggedIn(){
        UsersArchive archive = new UsersArchive();
        User loggedUser = archive.login("222-2222", "password2");
        assertNotNull(loggedUser);
        assertTrue(loggedUser.isLoggedIn());
    }
}
