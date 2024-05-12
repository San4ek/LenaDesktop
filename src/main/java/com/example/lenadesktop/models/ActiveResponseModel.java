package com.example.lenadesktop.models;

import java.util.Arrays;
import java.util.Objects;

public class ActiveResponseModel {

    public ActiveResponseModel() {
    }

    private long id;

    private String name;

    private String auditoryNumber;

    private String worker;

    private ActionModel[] actions;

    public ActiveResponseModel(long id, String name, String auditoryNumber, String worker, ActionModel[] actions) {
        this.id = id;
        this.name = name;
        this.auditoryNumber = auditoryNumber;
        this.worker = worker;
        this.actions = actions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuditoryNumber() {
        return auditoryNumber;
    }

    public void setAuditoryNumber(String auditoryNumber) {
        this.auditoryNumber = auditoryNumber;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public ActionModel[] getActions() {
        return actions;
    }

    public void setActions(ActionModel[] actions) {
        this.actions = actions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActiveResponseModel that)) return false;
        return getId() == that.getId() && Objects.equals(getName(), that.getName()) && Objects.equals(getAuditoryNumber(), that.getAuditoryNumber()) && Objects.equals(getWorker(), that.getWorker()) && Arrays.equals(getActions(), that.getActions());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getName(), getAuditoryNumber(), getWorker());
        result = 31 * result + Arrays.hashCode(getActions());
        return result;
    }

    @Override
    public String toString() {
        return "ActiveRequestModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", auditoryNumber='" + auditoryNumber + '\'' +
                ", worker='" + worker + '\'' +
                ", actions=" + Arrays.toString(actions) +
                '}';
    }
}
