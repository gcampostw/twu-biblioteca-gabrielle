package com.twu.biblioteca;

/**
 * Created by gcampos on 01/03/17.
 */
public class User {
    private String user;
    private String password;
    private boolean loggedIn;

    public User(String user, String password){
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
