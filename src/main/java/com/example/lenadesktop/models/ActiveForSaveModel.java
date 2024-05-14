package com.example.lenadesktop.models;

public class ActiveForSaveModel {

    public ActiveForSaveModel() {
    }

    public ActiveForSaveModel(Long id, String name, long worker, int type) {
        this.id = id;
        this.name = name;
        this.worker = worker;
        this.type = type;
    }

    private Long id;

    private String name;

    private long worker;

    private int type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getWorker() {
        return worker;
    }

    public void setWorker(long worker) {
        this.worker = worker;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
