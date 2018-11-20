package com.rnr.chebarbado.gymchessapp.models;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.rnr.chebarbado.gymchessapp.R;

public class BaseGymFragment extends MvpAppCompatFragment {
    protected int layout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(layout, container, false);
        viewsInit(rootView);

        return rootView;
    }

    private void viewsInit(View rootView) {
    }
}
