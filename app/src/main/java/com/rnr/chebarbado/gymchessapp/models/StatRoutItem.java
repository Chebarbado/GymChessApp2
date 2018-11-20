package com.rnr.chebarbado.gymchessapp.models;

public class StatRoutItem {
    private int id;
    private int time;
    private int value;
    private int weigth;
    private long date;
    private String type;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public StatRoutItem(int time, int value, int weigth, long date, String type) {

        this.time = time;
        this.value = value;
        this.weigth = weigth;
        this.date = date;
        this.type = type;
    }
}
