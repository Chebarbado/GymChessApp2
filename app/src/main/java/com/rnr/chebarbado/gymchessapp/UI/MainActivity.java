package com.rnr.chebarbado.gymchessapp.UI;

import android.support.v4.view.ViewPager;

import android.os.Bundle;

import android.view.Menu;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.astuetz.PagerSlidingTabStrip;
import com.rnr.chebarbado.gymchessapp.R;
import com.rnr.chebarbado.gymchessapp.controllers.MFragmentPagerAdapter;

public class MainActivity extends MvpAppCompatActivity {

    private boolean mIsRunning;
    private ViewPager viewPager;

    @Override
    protected void onResume() {
        mIsRunning = true;

        super.onResume();
    }

    @Override
    protected void onPause() {
        mIsRunning = false;
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTabs();
        if (savedInstanceState != null){
            viewPager.setCurrentItem(savedInstanceState.getInt("CURRENT_POSITION"));
        }
        else {}




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_set, menu);
        return true;
    }


    private void initTabs() {
        MFragmentPagerAdapter mFragmentPagerAdapter = new MFragmentPagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(mFragmentPagerAdapter);


        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabsStrip.setShouldExpand(true);
        // Attach the view pager to the tab strip
        tabsStrip.setViewPager(viewPager);


        tabsStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.

            @Override
            public void onPageSelected(int position) {
                if (mIsRunning) {
                    Toast.makeText(MainActivity.this,
                            "Selected page position: " + position, Toast.LENGTH_SHORT).show();
                }
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putInt("CURRENT_POSITION", viewPager.getCurrentItem());
        super.onSaveInstanceState(outState);

    }

}
