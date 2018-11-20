package com.rnr.chebarbado.gymchessapp.UI.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.rnr.chebarbado.gymchessapp.R;
import com.rnr.chebarbado.gymchessapp.controllers.GameSetupPresenter;
import com.rnr.chebarbado.gymchessapp.helper.SliderHelper;
import com.rnr.chebarbado.gymchessapp.interfaces.GameSetupView;
import com.rnr.chebarbado.gymchessapp.interfaces.OnSliderIndexChangeListener;
import com.rnr.chebarbado.gymchessapp.models.Game;
import com.rnr.chebarbado.gymchessapp.models.SliderItem;

import java.util.ArrayList;


public class GameSetupFragment extends MvpAppCompatFragment implements GameSetupView, OnSliderIndexChangeListener {
    public static final String TAG = "GAME_SETUP";
    private TextView selectedType, timeSetupTV, repeatsSetupTV, weigthSetpTV;
    private SeekBar timeSetupSB, repeatsSetupSB, weigthSetpSB;
    private Spinner spinner;
    private Button startButton;
    private RadioGroup playerCount;
    ArrayAdapter<?> adapter;
    private ArrayList<SliderItem> mSliderItemList;
    private View mSlider;
    private SliderHelper mSliderHelper;


    //Presenter
    @InjectPresenter
    GameSetupPresenter presenter;


    public static GameSetupFragment newInstance() {
        GameSetupFragment fragment = new GameSetupFragment();

        return fragment;

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game_setup, container, false);
        mSlider = rootView.findViewById(R.id.slider);
        viewsInit(rootView);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void viewsInit(View rootView) {

        spinner = (Spinner) rootView.findViewById(R.id.modelistSpinner);
        selectedType = (TextView) rootView.findViewById(R.id.selectedType);
        timeSetupTV = (TextView) rootView.findViewById(R.id.timeSetupTV);
        repeatsSetupTV = (TextView) rootView.findViewById(R.id.repeatsSetupTV);
        repeatsSetupSB = (SeekBar) rootView.findViewById(R.id.repeatsSetupSB);
        weigthSetpTV = (TextView) rootView.findViewById(R.id.weigthSetupTV);
        weigthSetpSB = (SeekBar) rootView.findViewById(R.id.weigthSetupSB);
        timeSetupSB = (SeekBar) rootView.findViewById(R.id.timeSetupSB);
        SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                switch (seekBar.getId()) {
                    case R.id.timeSetupSB:
                        presenter.setTime(seekBar.getProgress());
                        setTimePref(seekBar.getProgress());
                        break;
                    case R.id.repeatsSetupSB:
                        presenter.setRepeats(seekBar.getProgress());
                        setRepeatsCount(seekBar.getProgress());
                        break;
                    case R.id.weigthSetupSB:
                        presenter.setRoutine(0, seekBar.getProgress());
                        weigthSetpTV.setText("Weigth " + seekBar.getProgress() * 5);
                        break;
                }
            }
        };


        timeSetupSB.setOnSeekBarChangeListener(seekBarChangeListener);
        repeatsSetupSB.setOnSeekBarChangeListener(seekBarChangeListener);
        weigthSetpSB.setOnSeekBarChangeListener(seekBarChangeListener);

        playerCount = rootView.findViewById(R.id.playerCountRG);
        playerCount.setOnCheckedChangeListener((radioGroup, i) -> {
            switch (i) {
                case (R.id.playerCountRBone):
                    presenter.setPlayersCount(1);
                    break;
                case (R.id.playerCountRBtwo):
                    presenter.setPlayersCount(2);
                    break;
                case (R.id.playerCountRBthree):
                    presenter.setPlayersCount(3);
                    break;
                case (R.id.playerCountRBfour):
                    presenter.setPlayersCount(4);
                    break;
            }
        });

        startButton = (Button) rootView.findViewById(R.id.startB);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(presenter.startGame(getActivity()));
            }
        });

        prepareSlider();
        spinnerInit(spinner);

    }

    private void hideWeigth() {

        weigthSetpTV.setVisibility(View.GONE);
        weigthSetpSB.setVisibility(View.GONE);
    }

    private void showWeigth() {
        weigthSetpTV.setVisibility(View.VISIBLE);
        weigthSetpSB.setVisibility(View.VISIBLE);
    }


    private void spinnerInit(Spinner spinner) {

        // Настраиваем адаптер
        adapter =
                ArrayAdapter.createFromResource(getContext(), R.array.modelist, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Вызываем адаптер
        spinner.setAdapter(adapter);
        //Устанавливаем слушателя
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                presenter.setMode(selectedItemPosition);


            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


    //Команды из презентера

    @Override
    public void setType(int index) {
        mSliderHelper.jumpToPosition(index);
        Log.d("JUMPER", "setType: " + index);

    }

    @Override
    public void setModeType(int index) {
        adapter.getItem(index);
        Log.d("GSFragment", "Item number " + index + " was selected");
    }

    @Override
    public void setTimePref(int time) {
        timeSetupSB.setProgress(time);
        timeSetupTV.setText("Time " + time);
    }

    @Override
    public void setRepeatsCount(int repeatsCount) {
        repeatsSetupSB.setProgress(repeatsCount);
        repeatsSetupTV.setText("Repeats " + repeatsCount);
    }

    @Override
    public void setWeigth(int weigth) {
        weigthSetpSB.setProgress(weigth / 5);
        weigthSetpTV.setText("Weigth " + weigth);
    }

    @Override
    public void setPlayersCount(int playersCount) {

    }

    //Слайдер
    public void prepareSlider() {
        mSliderItemList = presenter.generateItems();
        mSliderHelper = new SliderHelper(getContext(), mSliderItemList, false, mSlider);
        mSliderHelper.setSlideButtonResources(R.drawable.ic_button_left, R.drawable.ic_button_right);
        mSliderHelper.setOnSliderIndexChangeListener(this);
    }

    @Override
    public void OnSliderIndexChanged(int newIndex) {
        presenter.setType(newIndex);
    }


}
