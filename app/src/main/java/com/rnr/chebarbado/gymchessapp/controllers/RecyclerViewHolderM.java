package com.rnr.chebarbado.gymchessapp.controllers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.rnr.chebarbado.gymchessapp.R;

public class RecyclerViewHolderM extends RecyclerView.ViewHolder implements View.OnClickListener{

    public Button button;

    public RecyclerViewHolderM(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        button = (Button) itemView.findViewById(R.id.button_reps);

    }

    @Override
    public void onClick(View view) {

    }
}
