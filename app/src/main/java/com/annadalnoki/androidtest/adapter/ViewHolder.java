package com.annadalnoki.androidtest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.annadalnoki.androidtest.R;

/**
 * Created by Anna on 17/02/27.
 */

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView title, genre, description;
    public ImageView image;

    public ViewHolder(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.image);
        title = (TextView) itemView.findViewById(R.id.title);
        genre = (TextView) itemView.findViewById(R.id.genre);
        description = (TextView) itemView.findViewById(R.id.description);
    }
}
