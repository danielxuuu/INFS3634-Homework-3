package com.example.cat;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;


public class CatRecyclerFragment extends Fragment {
    private RecyclerView recyclerView;
    public CatRecyclerFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_cat_recycler, container, false);
        recyclerView = view.findViewById(R.id.rv_main);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        CatAdapter catadapter = new CatAdapter();

        //volley
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        String url = "https://thecatapi.com";
        Response.Listener<String> responseListener =

        requestQueue.add(stringRequest);



    }

}
