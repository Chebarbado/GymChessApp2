package com.rnr.chebarbado.gymchessapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Routine implements Parcelable {


    private String type;
    private int weigth;
    private ArrayList<String> typeList = new ArrayList<String>();


    public Routine() {
        initRoutinList();
        this.type = typeList.get(0);
        this.weigth = 0;

    }

    public int getType() {
        return typeList.indexOf(type);
    }

    public String getTypeAsString(){
        return type;
    }

    public void setType(int id) {
        this.type = typeList.get(id);
    }

    public int getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    private void initRoutinList(){
        typeList.add("Horizontal Bar");
        typeList.add("Parallel Bar");
        typeList.add("Bench Press");
        typeList.add("Squat");
        typeList.add("Lifting the Rod on the Biceps");
    }

    protected Routine(Parcel in) {
        type = in.readString();
        weigth = in.readInt();
        if (in.readByte() == 0x01) {
            typeList = new ArrayList<String>();
            in.readList(typeList, String.class.getClassLoader());
        } else {
            typeList = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeInt(weigth);
        if (typeList == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(typeList);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Routine> CREATOR = new Parcelable.Creator<Routine>() {
        @Override
        public Routine createFromParcel(Parcel in) {
            return new Routine(in);
        }

        @Override
        public Routine[] newArray(int size) {
            return new Routine[size];
        }
    };
}