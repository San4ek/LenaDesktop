package com.example.lenadesktop.models;

public class ActionStateModel {

    public ActionStateModel() {
    }

    public ActionStateModel(int id, String type) {
        this.id=id;
        this.type = type;
    }

    private int id;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return type;
    }
}
