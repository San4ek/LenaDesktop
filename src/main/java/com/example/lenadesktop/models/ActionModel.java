package com.example.lenadesktop.models;

import java.time.LocalDateTime;

public class ActionModel {

    public ActionModel(String state, String dateTime) {
        this.state = state;
        this.dateTime = dateTime;
    }

    private String state;

    private String dateTime;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
