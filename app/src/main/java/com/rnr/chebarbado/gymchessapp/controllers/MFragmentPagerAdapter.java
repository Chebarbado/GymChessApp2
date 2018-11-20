package com.rnr.chebarbado.gymchessapp.controllers;


import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.astuetz.PagerSlidingTabStrip;
import com.rnr.chebarbado.gymchessapp.R;
import com.rnr.chebarbado.gymchessapp.UI.fragments.GameSetupFragment;
import com.rnr.chebarbado.gymchessapp.UI.fragments.StatsFragment;

public class MFragmentPagerAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {
    final int PAGE_COUNT = 4;

    private int tabIcons[] = {R.drawable.ic_game, R.drawable.ic_stat, R.drawable.ic_shop, R.drawable.ic_sett};


    public MFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Parcelable saveState() {
        return super.saveState();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 1:
                return StatsFragment.newInstance();
        }
        return GameSetupFragment.newInstance();
    }

    @Override
    public int getPageIconResId(int position) {
        return tabIcons[position];
    }
}