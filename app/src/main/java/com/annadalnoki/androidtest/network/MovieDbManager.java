package com.annadalnoki.androidtest.network;

import com.annadalnoki.androidtest.models.GenreListResponse;
import com.annadalnoki.androidtest.models.LoadPopularMoviesResponse;

import retrofit2.Callback;
import retrofit2.Retrofit;

public class MovieDbManager {
    //You can use this base url to load images with 342 pixel width
    public static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w342";

    //region singleton
    private static MovieDbManager instance;

    public static MovieDbManager getInstance() {
        if(instance == null) {
            instance = new MovieDbManager();
        }

        return instance;
    }
    //endregion

    private Retrofit retrofit;
    private MovieDbApi movieDbApi;

    private MovieDbManager(){
        retrofit = RetrofitHelper.initRetrofit();
        movieDbApi = retrofit.create(MovieDbApi.class);
    }

    public void loadPopularMovies(int page, Callback<LoadPopularMoviesResponse> callback) {
        movieDbApi.getPopularMovies(page).enqueue(callback);
    }

    public void loadGenreList(Callback<GenreListResponse> callback) {
        movieDbApi.getGenres().enqueue(callback);
    }
}
