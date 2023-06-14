package com.example.tmdbclient.data.model.movie


import com.google.gson.annotations.SerializedName

data class MovieList(

    @SerializedName("results")
    val tvShows: List<Movie>,

    )