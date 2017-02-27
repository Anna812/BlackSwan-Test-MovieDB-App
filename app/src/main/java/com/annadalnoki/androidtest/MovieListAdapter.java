package com.annadalnoki.androidtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.annadalnoki.androidtest.models.Movie;

import java.util.List;

/**
 * Created by Anna on 17/02/27.
 */

public class MovieListAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Movie> movies;
    private Context context;

    public MovieListAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View movieList = inflater.inflate(R.layout.movie_card, parent, false);

        ViewHolder viewHolder = new ViewHolder(movieList);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = movies.get(position);

        TextView title = holder.title;
        title.setText(movie.getTitle());

        TextView description = holder.description;
        description.setText(movie.getOverview());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
