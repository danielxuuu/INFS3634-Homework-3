package com.example.cat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;
//import com.example.cat.Cat;
//import com.example.cat.CatDetailActivity;


public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {
    private List<Cat> catsToAdapt;

    public void setData(List<Cat> catsToAdapt){this.catsToAdapt = catsToAdapt;}

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat, parent, false);

        CatViewHolder catViewHolder = new CatViewHolder(view);
        return catViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position){
        final Cat catAtPosition = catsToAdapt.get(position);
        holder.catNameTextView.setText(catAtPosition.getName());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, CatDetailActivity.class);
                intent.putExtra("id", catAtPosition.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(catsToAdapt.size() == 0){
            return 0;
        }
        return catsToAdapt.size();
    }


    public static class CatViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView catNameTextView;

        public CatViewHolder(View v){
            super(v);
            view = v;
            catNameTextView = v.findViewById(R.id.cat_name);
        }
    }

}
