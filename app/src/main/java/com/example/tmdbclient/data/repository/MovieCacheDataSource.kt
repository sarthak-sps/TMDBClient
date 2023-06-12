package com.example.tmdbclient.data.repository

import com.example.tmdbclient.data.model.movie.Movie

interface MovieCacheDataSource {
suspend fun getMoviesFromCache():List<Movie>
suspend fun saveMoviesFromCache(movies:List<Movie>)
}