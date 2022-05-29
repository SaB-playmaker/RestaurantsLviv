package com.restaurants.lviv.restLvivApplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RestaurantActivity extends AppCompatActivity {
    ImageView commentBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        commentBtn = findViewById(R.id.imageViewComment);
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
        commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RestaurantActivity.this, CommentsActivity.class);
                startActivity(intent);
            }
        });
    }
}