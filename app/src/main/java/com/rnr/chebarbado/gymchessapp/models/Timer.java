package com.rnr.chebarbado.gymchessapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Timer implements Parcelable {
    private int maxTime;
    private int estimatedTime;

    public int getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public Timer(int maxTime, int estimatedTime) {

        this.maxTime = maxTime;
        this.estimatedTime = estimatedTime;
    }

    protected Timer(Parcel in) {
        maxTime = in.readInt();
        estimatedTime = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(maxTime);
        dest.writeInt(estimatedTime);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Timer> CREATOR = new Parcelable.Creator<Timer>() {
        @Override
        public Timer createFromParcel(Parcel in) {
            return new Timer(in);
        }

        @Override
        public Timer[] newArray(int size) {
            return new Timer[size];
        }
    };
}