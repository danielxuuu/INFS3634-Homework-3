package com.example.cat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    public ImageView favouriteImageView;
    public boolean isFavourited = false;
    private String imageLink;


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
        catOrigin = findViewById(R.id.detailOrigin);
        catLifeSpan = findViewById(R.id.detailLifeSpan);
        url = findViewById(R.id.detailURL);
        dogLevel = findViewById(R.id.detailDogLevel);
        imageView = findViewById(R.id.detailImage);
        favouriteImageView = findViewById(R.id.fav);

        catName.setText(cat.getName());
        catDesc.setText(cat.getDescription());
        catTemp.setText(cat.getTemperament());
        catOrigin.setText(cat.getOrigin());
        catLifeSpan.setText(cat.getLife_span());
        url.setText(cat.getWikipedia_url());
        dogLevel.setText(String.valueOf(cat.getDog_friendly()));
        catWeight.setText(cat.getWeight_imperial());




        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://api.thecatapi.com/v1/images/search?breed_id=" + catID;


        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    if(jsonObject.has("url")){
                        imageLink = jsonObject.getString("url");
                        if(!imageLink.equals("")){
                            Glide.with(getApplicationContext()).load(imageLink).into(imageView);
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                } requestQueue.stop();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Request failed: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);
        requestQueue.add(stringRequest);

    }

}
