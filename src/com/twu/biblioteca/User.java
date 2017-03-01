package com.twu.biblioteca;

/**
 * Created by gcampos on 01/03/17.
 */
public class User {
    private String user;
    private String password;
    private final String name;
    private final String email;
    private final String phoneNumber;
    private boolean loggedIn;

    public User(String user, String password, String name, String email, String phoneNumber){
        this.user = user;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void login(){
        this.loggedIn = true;
    }

    @Override
    public boolean equals(Object user2){
        if(this.user.equalsIgnoreCase(((User) user2).user)){
            return true;
        }
        return false;
    }
}
