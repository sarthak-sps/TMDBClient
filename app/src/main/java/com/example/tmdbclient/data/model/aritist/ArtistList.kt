package com.example.tmdbclient.data.model.aritist


import com.google.gson.annotations.SerializedName

data class ArtistList(

    @SerializedName("results")
    val results: List<Artist>,

    )