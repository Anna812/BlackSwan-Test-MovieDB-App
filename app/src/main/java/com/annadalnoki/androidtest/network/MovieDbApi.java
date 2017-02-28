package com.annadalnoki.androidtest.network;

import com.annadalnoki.androidtest.models.GenreListResponse;
import com.annadalnoki.androidtest.models.LoadPopularMoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDbApi {

    @GET("movie/popular")
    Call<LoadPopularMoviesResponse> getPopularMovies(@Query("page") int page);

    @GET("genre/movie/list")
    Call<GenreListResponse> getGenres();
}
