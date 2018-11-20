package com.rnr.chebarbado.gymchessapp.controllers;

import android.util.Log;

import com.arellomobile.mvp.MvpPresenter;
import com.rnr.chebarbado.gymchessapp.interfaces.TimerView;
import com.rnr.chebarbado.gymchessapp.models.Game;
import com.rnr.chebarbado.gymchessapp.models.Timer;

import java.util.ArrayList;
import java.util.Set;

public class TimerFragmentPresenter extends MvpPresenter<TimerView> {
    private Game game = Game.getInstanse();
    private int curPlayerId;

    public void setCurPlayerId(int i){
        curPlayerId = i;
//        getViewState().setEstimatedTime(game.getEstimatedTime(i),"00:00:01");
    }

    @Override
    public void attachView(TimerView view) {
        curPlayerId = game.getCurrentPlayer();
        view.setMaxTime(game.getTime());
        view.setEstimatedTime(game.getEstimatedTime(curPlayerId), "00:00:00");
        super.attachView(view);
    }

    @Override
    protected void onFirstViewAttach() {
        game.setTimers();
        curPlayerId = 0;
        super.onFirstViewAttach();
    }



    @Override
    public Set<TimerView> getAttachedViews() {
        return super.getAttachedViews();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
