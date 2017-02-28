package com.annadalnoki.androidtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.annadalnoki.androidtest.R;

/**
 * Created by Anna on 17/02/27.
 */

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView title, genre, description, rating, date;
    public ImageView image;
    Context context;

    public ViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;

        image = (ImageView) itemView.findViewById(R.id.image);
        title = (TextView) itemView.findViewById(R.id.title);
        genre = (TextView) itemView.findViewById(R.id.genre);
        rating = (TextView) itemView.findViewById(R.id.rating);
        date = (TextView) itemView.findViewById(R.id.date);
        description = (TextView) itemView.findViewById(R.id.description);
    }
}
