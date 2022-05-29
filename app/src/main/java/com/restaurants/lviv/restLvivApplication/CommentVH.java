package com.restaurants.lviv.restLvivApplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CommentVH extends RecyclerView.ViewHolder
{
    public TextView txt_description_com,txt_rate_com,txt_option;
    public CommentVH(@NonNull View itemView)
    {
        super(itemView);
        txt_description_com = itemView.findViewById(R.id.txt_description_com);
        txt_rate_com = itemView.findViewById(R.id.txt_rate_com);
        txt_option = itemView.findViewById(R.id.txt_option);
    }
}
