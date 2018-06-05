package com.example.web.entities;

public class MemberLogin {
    private String login;
    private String password;
    MemberLogin() {

    }

    public String getLogin() {
        return this.login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
