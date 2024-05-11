package com.example.lenadesktop.configs;

import com.example.lenadesktop.models.User;

public class UserConfig {

    private static User user;

    public static User getUser() {
        return UserConfig.user;
    }

    public static void setUser(User user) {
        UserConfig.user = user;
    }

    public static void clearUser() {
        setUser(null);
    }
}
