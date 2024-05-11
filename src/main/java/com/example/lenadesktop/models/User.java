package com.example.lenadesktop.models;

import java.util.Objects;

public class User {

    public User() {
    }

    public User(Long id, String login, String password, boolean isBlocked, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.isBlocked = isBlocked;
        this.role = role;
    }

    private Long id;

    private String login;

    private String password;

    private boolean isBlocked;

    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", isBlocked=" + isBlocked +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return isBlocked() == user.isBlocked() && Objects.equals(getId(), user.getId()) && Objects.equals(getLogin(), user.getLogin()) && Objects.equals(getPassword(), user.getPassword()) && getRole() == user.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getPassword(), isBlocked(), getRole());
    }

    public enum Role {
        USER,
        ADMIN
    }
}
