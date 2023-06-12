package com.example.tmdbclient.data.repository

import com.example.tmdbclient.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMovieToDB(movie: List<Movie>)
    suspend fun clearAll()
}