package com.example.lenadesktop.models;

public class CredentialsModel {

    private String login;
    private String password;

    public CredentialsModel(String login, String password) {
        this.password = password;
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
