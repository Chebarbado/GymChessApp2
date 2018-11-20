package com.rnr.chebarbado.gymchessapp.controllers;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.rnr.chebarbado.gymchessapp.interfaces.GameActivityView;
import com.rnr.chebarbado.gymchessapp.models.Game;

@InjectViewState
public class GameActivityPresenter extends MvpPresenter<GameActivityView> {

    Game game = Game.getInstanse();


    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    @Override
    public void attachView(GameActivityView view) {
        view.setPlayersCountScreens(game.getPlayersCount());
        super.attachView(view);
    }

    public void setObservableScreen(int i){
        game.setCurrentPlayer(i);
    }
}
