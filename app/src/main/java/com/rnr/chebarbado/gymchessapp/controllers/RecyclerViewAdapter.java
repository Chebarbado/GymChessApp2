package com.rnr.chebarbado.gymchessapp.controllers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rnr.chebarbado.gymchessapp.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolderM> {

    private List<Integer> repsList;
    private Context context;

    public RecyclerViewAdapter(List<Integer> repsList, Context context) {
        this.repsList = repsList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolderM onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.button_view_list,null);
        RecyclerViewHolderM rvh = new RecyclerViewHolderM(layoutView);
        return rvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolderM rvhm, int i) {
        rvhm.button.setText(""+ repsList.get(i));
    }

    @Override
    public int getItemCount() {
        return this.repsList.size();
    }
}

