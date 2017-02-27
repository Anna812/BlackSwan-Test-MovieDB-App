package com.annadalnoki.androidtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.annadalnoki.androidtest.models.LoadPopularMoviesResponse;
import com.annadalnoki.androidtest.models.Movie;

import java.util.List;

/**
 * Created by Anna on 17/02/27.
 */

public class MovieListAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Movie> movies;
    private Context context;

    public MovieListAdapter(Context context, LoadPopularMoviesResponse loadPopularMoviesResponse) {
        this.context = context;
        movies = loadPopularMoviesResponse.getMovies();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
