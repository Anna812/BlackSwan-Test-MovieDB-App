package com.annadalnoki.androidtest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.widget.Toast;

import com.annadalnoki.androidtest.R;
import com.annadalnoki.androidtest.adapter.MovieListAdapter;
import com.annadalnoki.androidtest.models.Genre;
import com.annadalnoki.androidtest.models.GenreListResponse;
import com.annadalnoki.androidtest.models.LoadPopularMoviesResponse;
import com.annadalnoki.androidtest.models.Movie;
import com.annadalnoki.androidtest.network.MovieDbManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    RecyclerView recyclerView;
    List<Movie> movies;
    List<Genre> genres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecyclerView();
        loadGenres();
        startCallForList();
    }

    private void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.movielist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadGenres() {
        MovieDbManager.getInstance().loadGenreList(new Callback<GenreListResponse>() {

            @Override
            public void onResponse
                    (Call<GenreListResponse> call, Response<GenreListResponse> response){
                GenreListResponse genrelist = response.body();
                genres = genrelist.getGenres();

            }

            @Override
            public void onFailure (Call <GenreListResponse> call, Throwable t){
                Toast.makeText(MainActivity.this, "Error: " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startCallForList(){
        MovieDbManager.getInstance().loadPopularMovies(1,new Callback<LoadPopularMoviesResponse>() {

            @Override
            public void onResponse
            (Call <LoadPopularMoviesResponse> call, Response <LoadPopularMoviesResponse> response){
                LoadPopularMoviesResponse loadedMovies = response.body();
                movies = loadedMovies.getMovies();
                setupAdapter();
            }

            @Override
            public void onFailure (Call < LoadPopularMoviesResponse > call, Throwable t){
                Toast.makeText(MainActivity.this, "Error: " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void setupAdapter() {
        MovieListAdapter movieListAdapter = new MovieListAdapter(this, movies, genres);
        recyclerView.setAdapter(movieListAdapter);
    }
}
