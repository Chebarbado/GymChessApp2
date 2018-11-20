package com.rnr.chebarbado.gymchessapp.interfaces;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface GameSetupView extends MvpView{
    @StateStrategyType(AddToEndSingleStrategy.class)
    void setType(int index);
    void setModeType (int index);
    void setTimePref (int time);
    void setRepeatsCount (int repeatsCount);
    void setWeigth (int weigth);
    void setPlayersCount(int playersCount);
}
