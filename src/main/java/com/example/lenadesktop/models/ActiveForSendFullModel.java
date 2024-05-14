package com.example.lenadesktop.models;

import java.util.Arrays;
import java.util.Objects;

public class ActiveForSendFullModel {

    public ActiveForSendFullModel() {
    }

    private long id;

    private String name;

    private String type;

    private String auditoryNumber;

    private String worker;

    private ActionForSendModel[] actions;

    public ActiveForSendFullModel(long id, String name, String type, String auditoryNumber, String worker, ActionForSendModel[] actions) {
        this.id = id;
        this.name = name;
        this.type=type;
        this.auditoryNumber = auditoryNumber;
        this.worker = worker;
        this.actions = actions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public ActionForSendModel[] getActions() {
        return actions;
    }

    public void setActions(ActionForSendModel[] actions) {
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "ActiveResponseModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", auditoryNumber='" + auditoryNumber + '\'' +
                ", worker='" + worker + '\'' +
                ", actions=" + Arrays.toString(actions) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActiveForSendFullModel that)) return false;
        return getId() == that.getId() && Objects.equals(getName(), that.getName()) && Objects.equals(getType(), that.getType()) && Objects.equals(getAuditoryNumber(), that.getAuditoryNumber()) && Objects.equals(getWorker(), that.getWorker()) && Arrays.equals(getActions(), that.getActions());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getName(), getType(), getAuditoryNumber(), getWorker());
        result = 31 * result + Arrays.hashCode(getActions());
        return result;
    }
}
