package com.annadalnoki.androidtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.annadalnoki.androidtest.R;
import com.annadalnoki.androidtest.models.Genre;
import com.annadalnoki.androidtest.models.Movie;
import com.annadalnoki.androidtest.network.MovieDbManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Anna on 17/02/27.
 */

public class MovieListAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Movie> movies;
//    private List<Genre> genres;
    Context context;

    public MovieListAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
//        loadGenres();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View movieList = inflater.inflate(R.layout.movie_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(movieList);

        return viewHolder;
    }

//    private void loadGenres() {
//        MovieDbManager.getInstance().loadGenreList(new Callback<List<Genre>>() {
//
//            @Override
//            public void onResponse
//                (Call<List<Genre>> call, Response<List<Genre>> response){
//                genres = response.body();
//            }
//
//            @Override
//            public void onFailure (Call <List<Genre>> call, Throwable t){
//                Toast.makeText(context, "Error: " + t.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = movies.get(position);

        holder.title.setText(movie.getTitle());
        holder.description.setText(movie.getOverview());
//        holder.genre.setText(defineGenre(movie));
    }

//    private String defineGenre(Movie movie) {
//        String result = "";
//        for (int temp : movie.getGenreIdList()) {
//            for (Genre genre : genres) {
//                if(temp == genre.getId()) {
//                    result += genre.getName() + ", ";
//                }
//            }
//        }
//        return result;
//    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
