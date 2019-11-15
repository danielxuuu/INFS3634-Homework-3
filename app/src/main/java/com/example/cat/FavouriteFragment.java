package com.example.cat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavouriteFragment extends Fragment {

    private RecyclerView recyclerView;
    private CatAdapter catAdapter = new CatAdapter((List<Cat>) getContext());
    private List<Cat> cats;

    public FavouriteFragment() {
        //empty
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);
        recyclerView = view.findViewById(R.id.rv_favourite);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        return view;

    }
}
