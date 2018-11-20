package com.rnr.chebarbado.gymchessapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Parcelable {
    private String name;
    private int id;
    private int score;
    private int gymchesses;
    private ArrayList<Records> records;

    public Player(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGymchesses() {
        return gymchesses;
    }

    public void setGymchesses(int gymchesses) {
        this.gymchesses = gymchesses;
    }

    public ArrayList<Records> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Records> records) {
        this.records = records;
    }

    protected Player(Parcel in) {
        name = in.readString();
        id = in.readInt();
        score = in.readInt();
        gymchesses = in.readInt();
        if (in.readByte() == 0x01) {
            records = new ArrayList<Records>();
            in.readList(records, Records.class.getClassLoader());
        } else {
            records = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(id);
        dest.writeInt(score);
        dest.writeInt(gymchesses);
        if (records == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(records);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Player> CREATOR = new Parcelable.Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };
}