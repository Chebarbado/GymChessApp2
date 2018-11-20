package com.rnr.chebarbado.gymchessapp.interfaces;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.ArrayList;

public interface GameView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showNextPlayer();
    void showGameOverMessage(String message);
    void showButtons(ArrayList<Integer> buttons, int indexOfPlayer);
    void setCurrentPlayerName(String name);
    void showTimer(int indexOfPlayer);


}
