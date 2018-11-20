package com.rnr.chebarbado.gymchessapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Records implements Parcelable {
    private String routineName;
    private String recordOwner;
    private int totalRepeats;
    private int totalTime;
    private ArrayList<Integer> approaches;
    private ArrayList<Long> timeForApproach;
    private int weigth;

    public String getRoutineName() {
        return routineName;
    }

    public void setRoutineName(String routineName) {
        this.routineName = routineName;
    }

    public String getRecordOwner() {
        return recordOwner;
    }

    public void setRecordOwner(String recordOwner) {
        this.recordOwner = recordOwner;
    }

    public int getTotalRepeats() {
        return totalRepeats;
    }

    public void setTotalRepeats(int totalRepeats) {
        this.totalRepeats = totalRepeats;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public ArrayList<Integer> getApproaches() {
        return approaches;
    }

    public void setApproaches(ArrayList<Integer> approaches) {
        this.approaches = approaches;
    }

    public ArrayList<Long> getTimeForApproach() {
        return timeForApproach;
    }

    public void setTimeForApproach(ArrayList<Long> timeForApproach) {
        this.timeForApproach = timeForApproach;
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

    private long date;

    protected Records(Parcel in) {
        routineName = in.readString();
        recordOwner = in.readString();
        totalRepeats = in.readInt();
        totalTime = in.readInt();
        if (in.readByte() == 0x01) {
            approaches = new ArrayList<Integer>();
            in.readList(approaches, Integer.class.getClassLoader());
        } else {
            approaches = null;
        }
        if (in.readByte() == 0x01) {
            timeForApproach = new ArrayList<Long>();
            in.readList(timeForApproach, Long.class.getClassLoader());
        } else {
            timeForApproach = null;
        }
        weigth = in.readInt();
        date = in.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(routineName);
        dest.writeString(recordOwner);
        dest.writeInt(totalRepeats);
        dest.writeInt(totalTime);
        if (approaches == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(approaches);
        }
        if (timeForApproach == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(timeForApproach);
        }
        dest.writeInt(weigth);
        dest.writeLong(date);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Records> CREATOR = new Parcelable.Creator<Records>() {
        @Override
        public Records createFromParcel(Parcel in) {
            return new Records(in);
        }

        @Override
        public Records[] newArray(int size) {
            return new Records[size];
        }
    };
}