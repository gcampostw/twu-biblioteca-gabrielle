package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class UsersArchive {
    private List<User> users;
    private User loggedUser;

    public UsersArchive(){
        load();
    }

    private void load(){
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

    public User login(String user, String password) {
        User archivedUser;
        try{
            archivedUser = getUser(user);
            if(archivedUser.getPassword().equals(password)){
                archivedUser.login();
            }else{
                archivedUser = null;
            }
        }catch(IndexOutOfBoundsException e){
            archivedUser = null;
        }
        return archivedUser;
    }

    public User getUser(String username) throws IndexOutOfBoundsException{
        User user = new User(username, null, null, null, null);
        return users.get(users.indexOf(user));
    }

    public boolean isUserLogged(){
        boolean isLogged = false;
        if(this.loggedUser != null){
            isLogged = true;
        }
        return isLogged;
    }

    public void setLoggedUser(User user){
        this.loggedUser = user;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public String getLoggedUserInformation(){
        User user = this.loggedUser;
        String userInformation = "---------- User Details ----------\n";
        userInformation += String.format("Name: %s\nEmail: %s\nPhone: %s\n", user.getName(), user.getEmail(),
                user.getPhoneNumber());
        userInformation += "----------------------------------";
        return userInformation;
    }

}
