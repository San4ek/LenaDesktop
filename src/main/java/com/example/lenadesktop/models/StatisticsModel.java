package com.example.lenadesktop.models;

public class StatisticsModel {

    private long writeOffValue;

    private long inUsingValue;

    private String type;

    public long getWriteOffValue() {
        return writeOffValue;
    }

    public void setWriteOffValue(long writeOffValue) {
        this.writeOffValue = writeOffValue;
    }

    public long getInUsingValue() {
        return inUsingValue;
    }

    public void setInUsingValue(long inUsingValue) {
        this.inUsingValue = inUsingValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
