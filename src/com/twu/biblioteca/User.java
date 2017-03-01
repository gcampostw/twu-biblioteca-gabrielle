package com.twu.biblioteca;

/**
 * Created by gcampos on 01/03/17.
 */
public class User {
    private String login;
    private String password;
    private boolean loggedIn;

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    @Override
    public boolean equals(Object user2){
        if(this.login.equalsIgnoreCase(((User) user2).login)){
            return true;
        }
        return false;
    }
}
