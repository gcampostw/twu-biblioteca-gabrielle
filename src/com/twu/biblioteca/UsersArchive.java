package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class UsersArchive {
    private List<User> users;

    public UsersArchive(List<User> users){
        if(users == null){
            load();
        }else{
            this.users = users;
        }
    }

    public void load(){
        User user1 = new User("111-1111","password1", "User Number 1",
                "usernbm1@gmail.com", "81981889999");
        User user2 = new User("222-2222","password2", "User Number 2",
                "usernbm2@gmail.com", "81982889999");
        User user3 = new User("333-3333","password3", "User Number 3",
                "usernbm1@gmail.com", "81983889999");
        User user4 = new User("444-4444","password4", "User Number 4",
                "usernbm1@gmail.com", "81984889999");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        this.users = users;
    }

    public User getUser(String username) throws IndexOutOfBoundsException{
        User user = new User(username, null, null, null, null);
        return users.get(users.indexOf(user));
    }

}
