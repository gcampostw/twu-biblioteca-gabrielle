package com.twu.biblioteca;

import java.util.List;

public class UsersArchive {
    private List<User> users;

    public UsersArchive(List<User> users){
        this.users = users;
    }

    public User getUser(String username) throws IndexOutOfBoundsException{
        User user = new User(username, null, null, null, null);
        return users.get(users.indexOf(user));
    }

}
