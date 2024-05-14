package com.example.lenadesktop.models;

public class CredentialsModel {

    private String login;
    private String password;
    private boolean isBLocked;

    public CredentialsModel(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public CredentialsModel(String login, String password, boolean isBLocked) {
        this.password = password;
        this.login = login;
        this.isBLocked=isBLocked;
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

    public boolean isBLocked() {
        return isBLocked;
    }

    public void setBLocked(boolean BLocked) {
        isBLocked = BLocked;
    }
}
