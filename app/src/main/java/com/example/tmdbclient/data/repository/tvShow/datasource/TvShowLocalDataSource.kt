package com.example.tmdbclient.data.repository.tvShow.datasource

import com.example.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getMoviesFromDB():List<TvShow>
    suspend fun saveMovieToDB(movie: List<TvShow>)
    suspend fun clearAll()
}