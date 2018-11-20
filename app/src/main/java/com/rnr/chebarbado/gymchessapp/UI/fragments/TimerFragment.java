package com.rnr.chebarbado.gymchessapp.UI.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.github.guilhe.circularprogressview.CircularProgressView;
import com.rnr.chebarbado.gymchessapp.R;
import com.rnr.chebarbado.gymchessapp.controllers.TimerFragmentPresenter;
import com.rnr.chebarbado.gymchessapp.interfaces.TimerView;


public class TimerFragment extends MvpAppCompatFragment implements TimerView {
    CircularProgressView progressView;
    CircularProgressView arrow;
    TextView timerTV;


    @InjectPresenter
    TimerFragmentPresenter presenter;


    public static TimerFragment newInstance() {
        TimerFragment timerFragment = new TimerFragment();

        return timerFragment;
    }

    public void setCurrentPlayer(int id){
        presenter.setCurPlayerId(id);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_timer, container, false);
        progressView = (CircularProgressView) rootView.findViewById(R.id.circleTimerValueCPV);
        arrow = (CircularProgressView) rootView.findViewById(R.id.arrow);
        timerTV = (TextView) rootView.findViewById(R.id.timeDisplayTV);


        return rootView;
    }

    @Override
    public void setEstimatedTime(int estimatedTime, String estimatedTimeText) {
        progressView.setProgress(estimatedTime);
        arrow.setProgress(estimatedTime);
        timerTV.setText(estimatedTimeText);
    }

    @Override
    public void setMaxTime(int maxTime) {
        progressView.setMax(maxTime);
        arrow.setMax(maxTime);
    }
}
