package com.example.cat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CatDetailActivity extends AppCompatActivity {
    private TextView catName;
    private TextView catDesc;
    private TextView catWeight;
    private TextView catTemp;
    private TextView catOrigin;
    private TextView catLifeSpan;
    private TextView url;
    private TextView dogLevel;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_detail);
        Intent intent = getIntent();
        String catID = intent.getStringExtra("id");
        Cat cat = CatDatabase.getCatById(catID);

        catName = findViewById(R.id.detailName);
        catDesc = findViewById(R.id.detailDescription);
        catWeight = findViewById(R.id.detailWeight);
        catTemp = findViewById(R.id.detailTemp);
        catOrigin = findViewById(R.id.detailLifeSpan);
        catLifeSpan = findViewById(R.id.detailLifeSpan);
        url = findViewById(R.id.detailURL);
        dogLevel = findViewById(R.id.detailDogLevel);
//        imageView = findViewById(R.id.detailImage);

        catName.setText(cat.getName());
        catDesc.setText(cat.getDescription());
        catWeight.setText(cat.getWeight_imperial());
        catTemp.setText(cat.getTemperament());
        catOrigin.setText(cat.getOrigin());
        catLifeSpan.setText(cat.getLife_span());
        url.setText(cat.getWikipedia_url());
        dogLevel.setText(String.valueOf(cat.getDog_friendly()));
       // imageView.

    }
}
