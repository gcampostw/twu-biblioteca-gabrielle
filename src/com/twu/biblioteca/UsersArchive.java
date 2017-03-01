package com.twu.biblioteca;

import exceptions.BookNotFoundException;
import exceptions.UserNotFoundException;

import java.util.List;

/**
 * Created by gcampos on 01/03/17.
 */
public class UsersArchive {
    private List<User> users;

    public UsersArchive(List<User> users){
        this.users = users;
    }

    public User getUser(User user) throws UserNotFoundException {
        if(users.indexOf(user) < 0){
            throw new UserNotFoundException();
        }
        return users.get(users.indexOf(user));
    }

}
