package com.example.tmdbclient.data.repository.movie.datasourceImpl

import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {
    private var movieList= ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesFromCache(tvShows: List<Movie>) {
        movieList.clear()
        movieList=ArrayList(tvShows)
    }
}