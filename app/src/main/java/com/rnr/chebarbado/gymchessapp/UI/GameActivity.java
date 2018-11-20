package com.rnr.chebarbado.gymchessapp.UI;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.rnr.chebarbado.gymchessapp.R;
import com.rnr.chebarbado.gymchessapp.UI.fragments.GameFragment;
import com.rnr.chebarbado.gymchessapp.controllers.GameActivityPresenter;
import com.rnr.chebarbado.gymchessapp.interfaces.GameActivityView;

public class GameActivity extends MvpAppCompatActivity implements GameActivityView {

    private ViewPager viewPlayer;
    private int countOfScreens = 1;

    @InjectPresenter
    GameActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


    }

    private void initView() {
        FragmentPagerAdapter fma = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {

                return GameFragment.newInstance();

            }

            @Override
            public int getCount() {
                return countOfScreens;
            }
        };

        viewPlayer = (ViewPager) findViewById(R.id.viewPlayerPager);
        viewPlayer.setAdapter(fma);

        viewPlayer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                Log.d("ПОМЕНЯЛАСЬ СТРАНИЦА", "НА СТРАНИЦУ НОМЕР " + i);
                presenter.setObservableScreen(i);
                GameFragment.newInstance().showTimer(i);
                
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }


    @Override
    public void setPlayersCountScreens(int i) {
        countOfScreens = i;
        initView();
    }
}
