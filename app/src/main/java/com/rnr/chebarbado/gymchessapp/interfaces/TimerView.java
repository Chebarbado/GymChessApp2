package com.rnr.chebarbado.gymchessapp.interfaces;

import com.arellomobile.mvp.MvpView;

public interface TimerView extends MvpView {
    void setEstimatedTime(int estimatedTime, String estimatedTimeText);
    void setMaxTime(int maxTime);
}
