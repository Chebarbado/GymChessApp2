package com.rnr.chebarbado.gymchessapp.controllers;

import android.app.Activity;
import android.content.Intent;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.rnr.chebarbado.gymchessapp.R;
import com.rnr.chebarbado.gymchessapp.UI.GameActivity;
import com.rnr.chebarbado.gymchessapp.UI.MainActivity;
import com.rnr.chebarbado.gymchessapp.UI.fragments.GameSetupFragment;
import com.rnr.chebarbado.gymchessapp.helper.SliderHelper;
import com.rnr.chebarbado.gymchessapp.interfaces.GameSetupView;
import com.rnr.chebarbado.gymchessapp.models.Game;
import com.rnr.chebarbado.gymchessapp.models.Player;
import com.rnr.chebarbado.gymchessapp.models.Routine;
import com.rnr.chebarbado.gymchessapp.models.SliderItem;

import java.util.ArrayList;

@InjectViewState
public class GameSetupPresenter extends MvpPresenter<GameSetupView> {

    private Game game = Game.getInstanse();
    private int type;
    private int playersCount;


    @Override
    public void attachView(GameSetupView view) {
        view.setType(type);
        view.setModeType(game.getMode());
        view.setPlayersCount(game.getPlayersCount());
        view.setRepeatsCount(game.getRepeats());
        view.setTimePref(game.getTime());
        super.attachView(view);
    }

    @Override
    protected void onFirstViewAttach() {
        type = 0;
        setMode(0);
        this.game = Game.getInstanse();
        super.onFirstViewAttach();
    }

    public void setMode(int mode) {
        game.setMode(mode);

    }

    public void setPlayersCount(int playersCount) {
       this.playersCount = playersCount;

    }

    public void setRoutine(int type, int weigth) {
        weigth*=5;
        game.setRoutine(type, weigth);

    }

    public void setTime(int time) {
        game.setTime(time);

    }

    public void setRepeats(int repeats) {
        game.setRepeats(repeats);

    }

    public void setType(int type){
        this.type = type;

    }

    public Intent startGame(Activity activity) {
        Intent intent = new Intent(activity, GameActivity.class);
        game.setPlayers(playersCount);
        intent.putExtra("GAME_PREFS", game);
        return intent;
    }



    public ArrayList<SliderItem> generateItems() {
        ArrayList<SliderItem> items = new ArrayList<>();
        int[] colorResourceIds = {
                android.R.color.holo_blue_bright,
                android.R.color.holo_blue_dark,
                android.R.color.holo_green_light,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_light,
        };
        int[] imageResourceIds = {
                R.drawable.ic_category_1,
                R.drawable.ic_category_2,
                R.drawable.ic_category_3,
                R.drawable.ic_category_4,
                R.drawable.ic_category_5,
        };
        for (int i = 0; i < 5; i++) {
            items.add(new SliderItem(
                    "Label " + i,
                    imageResourceIds[i],
                    colorResourceIds[i],
                    230,
                    300
            ));
        }
        return items;
    }
}
