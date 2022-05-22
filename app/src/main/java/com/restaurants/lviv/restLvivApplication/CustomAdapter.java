package com.restaurants.lviv.restLvivApplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList restaurant_id, restaurant_name, restaurant_description, restaurant_rate;

    CustomAdapter(Activity activity, Context context, ArrayList restaurant_id, ArrayList restaurant_name, ArrayList restaurant_description,
                  ArrayList restaurant_rate){
        this.activity = activity;
        this.context = context;
        this.restaurant_id = restaurant_id;
        this.restaurant_name = restaurant_name;
        this.restaurant_description = restaurant_description;
        this.restaurant_rate = restaurant_rate;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.restaurant_id_txt.setText(String.valueOf(restaurant_id.get(position)));
        holder.restaurant_name_txt.setText(String.valueOf(restaurant_name.get(position)));
        holder.restaurant_description_txt.setText(String.valueOf(restaurant_description.get(position)));
        holder.restaurant_rate_txt.setText(String.valueOf(restaurant_rate.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(restaurant_id.get(position)));
                intent.putExtra("title", String.valueOf(restaurant_name.get(position)));
                intent.putExtra("author", String.valueOf(restaurant_description.get(position)));
                intent.putExtra("pages", String.valueOf(restaurant_rate.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return restaurant_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView restaurant_id_txt, restaurant_name_txt, restaurant_description_txt, restaurant_rate_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurant_id_txt = itemView.findViewById(R.id.restaurant_id_txt);
            restaurant_name_txt = itemView.findViewById(R.id.restaurant_name_txt);
            restaurant_description_txt = itemView.findViewById(R.id.description_txt);
            restaurant_rate_txt = itemView.findViewById(R.id.rate_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}
