package com.example.lenadesktop.models;

import java.util.Date;

public class ActionForSendModel {

    public ActionForSendModel() {
    }

    public ActionForSendModel(String state, Date dateTime) {
        this.state = state;
        this.dateTime = dateTime;
    }

    private String state;

    private Date dateTime;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
