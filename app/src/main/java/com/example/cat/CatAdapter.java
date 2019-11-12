package com.example.cat;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CatAdapter{
    private List<Cat> catsToAdapt;

    public void setData(List<Cat> catsToAdapt){this.catsToAdapt = catsToAdapt;}

    public CatViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat, parent, false);

        CatViewHolder catViewHolder = new CatViewHolder(view);
        return catViewHolder;
    }

    public void onBindViewHolder(CatViewHolder holder, int position){
        Cat catAtPosition = catsToAdapt.get(position);
        //do the holder stuff
    }


    public static class CatViewHolder extends RecyclerView.ViewHolder{
        public View view;
    //    public 
    }

}
