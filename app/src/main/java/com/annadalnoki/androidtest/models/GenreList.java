package com.annadalnoki.androidtest.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Anna on 17/02/28.
 */

public class GenreList implements Serializable{

    @SerializedName("genres")
    List<Genre> genres;

    public List<Genre> getGenres() {
        return genres;
    }
}
