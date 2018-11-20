package com.rnr.chebarbado.gymchessapp.controllers;

import android.util.Log;

import com.arellomobile.mvp.MvpPresenter;
import com.rnr.chebarbado.gymchessapp.interfaces.GameView;
import com.rnr.chebarbado.gymchessapp.models.Game;

public class GameFragmentPresenter extends MvpPresenter<GameView> {
    private int curPlayerId;
    private Game game = Game.getInstanse();

    @Override
    public void attachView(GameView view) {
        curPlayerId = game.getCurrentPlayer();
        view.showTimer(curPlayerId);


        super.attachView(view);
    }

    public void setCurPlayerId (int id){
        curPlayerId = id;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    @Override
    public void detachView(GameView view) {
        super.detachView(view);
    }
}
