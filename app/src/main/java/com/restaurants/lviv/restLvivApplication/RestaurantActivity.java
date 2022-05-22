package com.restaurants.lviv.restLvivApplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyRestaurantData[] myRestaurantData = new MyRestaurantData[]{
                new MyRestaurantData("Restaurant1","8 ",R.drawable.rest1),
                new MyRestaurantData("Restaurant2","9 ",R.drawable.rest2),
                new MyRestaurantData("Restaurant3","10 ",R.drawable.rest3),
                new MyRestaurantData("Restaurant4","7 ",R.drawable.rest4),
                new MyRestaurantData("Restaurant5","7 ",R.drawable.rest5),
                new MyRestaurantData("Restaurant6","8 ",R.drawable.rest6),
                new MyRestaurantData("Restaurant7","6",R.drawable.rest7),
        };

        MyRestaurantAdapter myRestaurantAdapter = new MyRestaurantAdapter(myRestaurantData,RestaurantActivity.this);
        recyclerView.setAdapter(myRestaurantAdapter);

    }
}