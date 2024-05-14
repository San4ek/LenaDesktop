package com.example.lenadesktop.models;

import java.util.Date;

public class ActionForSaveModel {

    private long activeId;

    private Date dateTime;

    private int state;

    public ActionForSaveModel() {
    }

    public ActionForSaveModel(long activeId, Date dateTime, int state) {
        this.activeId = activeId;
        this.dateTime = dateTime;
        this.state = state;
    }

    public long getActiveId() {
        return activeId;
    }

    public void setActiveId(long activeId) {
        this.activeId = activeId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
