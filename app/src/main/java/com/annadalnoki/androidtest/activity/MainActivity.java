package com.annadalnoki.androidtest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.annadalnoki.androidtest.R;
import com.annadalnoki.androidtest.RecyclerItemClickListener;
import com.annadalnoki.androidtest.adapter.MovieListAdapter;
import com.annadalnoki.androidtest.models.Genre;
import com.annadalnoki.androidtest.models.GenreListResponse;
import com.annadalnoki.androidtest.models.LoadPopularMoviesResponse;
import com.annadalnoki.androidtest.models.Movie;
import com.annadalnoki.androidtest.network.MovieDbManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    RecyclerView recyclerView;
    MovieListAdapter movieListAdapter;
    List<Movie> movies;
    List<Genre> genres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movies = new ArrayList<>();
        genres = new ArrayList<>();

        setupRecyclerView();
        loadGenres();
        startCallForList();
    }

    private void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.movielist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        movieListAdapter = new MovieListAdapter(this, movies, genres);
        recyclerView.setAdapter(movieListAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Log.e("Main", "onitemtouch");
                        Intent i = new Intent(getApplicationContext(), DetailedPageActivity.class);
                        Bundle movieToShow = new Bundle();
                        movieToShow.putSerializable("movie", movies.get(position));
                        i.putExtra("movie", movieToShow);
                        startActivity(i);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                    }
                })
        );
    }

    private void loadGenres() {
        MovieDbManager.getInstance().loadGenreList(new Callback<GenreListResponse>() {

            @Override
            public void onResponse
                    (Call<GenreListResponse> call, Response<GenreListResponse> response){
                GenreListResponse genrelist = response.body();
                genres.addAll(genrelist.getGenres());
                movieListAdapter.notifyDataSetChanged();
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
                movies.addAll(loadedMovies.getMovies());
                movieListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure (Call < LoadPopularMoviesResponse > call, Throwable t){
                Toast.makeText(MainActivity.this, "Error: " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
