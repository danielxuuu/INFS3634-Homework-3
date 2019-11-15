package com.example.cat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
//import com.example.cat.Cat;
//import com.example.cat.CatDetailActivity;


public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> implements Filterable {
    private List<Cat> catsToAdapt;
    private List <Cat> catsToAdaptFull;

    public CatAdapter() {

    }

    public void setData(List<Cat> catsToAdapt){this.catsToAdapt = catsToAdapt;}

    CatAdapter(List<Cat> catsToAdapt){
        catsToAdaptFull = new ArrayList<>(catsToAdapt);
    }

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
        public ImageView favImageView;
        public Boolean isFavourited = false;

        public CatViewHolder(View v){
            super(v);
            view = v;
            catNameTextView = v.findViewById(R.id.cat_name);
            favImageView = v.findViewById(R.id.fav);


//            favImageView.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View view){
//                    if(isFavourited){
//                        favImageView.setImageResource(R.drawable.ic_favorite_border_black_24dp);
//                    } else {
//                        favImageView.setImageResource(R.drawable.ic_favorite_black_24dp);
//                    }
//                    isFavourited = !isFavourited;
//                }
//            });


        }
    }





    @Override
    public Filter getFilter(){
        return catFilter;
    }

    private Filter catFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Cat> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(catsToAdaptFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Cat item : catsToAdaptFull){
                    if (item.getName().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults srchRes = new FilterResults();
            srchRes.values = filteredList;

            return srchRes;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults srchRes) {
            catsToAdapt.clear();
            catsToAdapt.addAll((List) srchRes.values);
            notifyDataSetChanged();

        }
    };

}
