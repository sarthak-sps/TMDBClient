package com.example.tmdbclient.data.repository

import com.example.tmdbclient.data.model.movie.Movie

class MovieCacheDataSourceImpl:MovieCacheDataSource {
    private var movieList= ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesFromCache(movies: List<Movie>) {
        movieList.clear()
        movieList=ArrayList(movies)
    }
}