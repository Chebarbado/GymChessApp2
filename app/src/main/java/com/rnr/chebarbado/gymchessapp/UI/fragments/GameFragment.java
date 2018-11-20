package com.rnr.chebarbado.gymchessapp.UI.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.rnr.chebarbado.gymchessapp.R;
import com.rnr.chebarbado.gymchessapp.controllers.GameFragmentPresenter;
import com.rnr.chebarbado.gymchessapp.controllers.RecyclerViewAdapter;
import com.rnr.chebarbado.gymchessapp.interfaces.GameView;
import com.rnr.chebarbado.gymchessapp.models.BaseGymFragment;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class GameFragment extends MvpAppCompatFragment implements GameView {

    protected int layout = R.layout.fragment_game;
    private static String FRAGMENT_INSTANCE_NAME = "Fragment";
    private GridLayoutManager gridLayout;
    private List<Integer> repsTable = new ArrayList<Integer>();
    private TimerFragment timerFragment = null;

    @InjectPresenter
    GameFragmentPresenter gameFragmentPresenter;


    public static GameFragment newInstance() {
        GameFragment gameFragment = new GameFragment();

        return gameFragment;

    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(layout, container, false);
        viewsInit(rootView);

        return rootView;
    }

    @Override
    public void onResume() {

        super.onResume();
    }


    private void viewsInit(View rootView) {
        setTimerFragment();
        gridLayout = new GridLayoutManager(getContext(), 4);
        repsTable.clear();
        for (int i = 1; i < 16; i++) {
            repsTable.add(i);
        }
        RecyclerView rView = (RecyclerView) rootView.findViewById(R.id.buttonTable);
        rView.hasFixedSize();
        rView.setLayoutManager(gridLayout);
        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(repsTable, getContext());
        rView.setAdapter(rcAdapter);


    }

    public void setTimerFragment() {
        FragmentManager fragmentManager = getChildFragmentManager();
        timerFragment = TimerFragment.newInstance();
        fragmentManager.beginTransaction().replace(R.id.timerFL, timerFragment, FRAGMENT_INSTANCE_NAME).commit();

    }

    @Override
    public void showNextPlayer() {

    }

    @Override
    public void showGameOverMessage(String message) {

    }

    @Override
    public void showButtons(ArrayList<Integer> buttons, int indexOfPlayer) {

    }

    @Override
    public void setCurrentPlayerName(String name) {

    }


    @Override
    public void showTimer(int indexOfPlayer) {
        Log.d("ОШИБОЧКА","IN SHOW TIMER "+gameFragmentPresenter.toString()+ " " + indexOfPlayer);
        gameFragmentPresenter.setCurPlayerId(indexOfPlayer);

    }


}
