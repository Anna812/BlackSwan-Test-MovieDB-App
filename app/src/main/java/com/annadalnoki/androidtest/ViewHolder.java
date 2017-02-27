package com.annadalnoki.androidtest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Anna on 17/02/27.
 */

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView title, genre, description;

    public ViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        genre = (TextView) itemView.findViewById(R.id.genre);
        description = (TextView) itemView.findViewById(R.id.description);
    }
}
