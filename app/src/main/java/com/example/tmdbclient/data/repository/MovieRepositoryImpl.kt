package com.example.tmdbclient.data.repository

import android.util.Log
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateMovies(): List<Movie>? {
        TODO("Not yet implemented")
    }

    suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (exception: java.lang.Exception) {
            Log.d("MyTAG", exception.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromD(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
           movieList=movieLocalDataSource.getMoviesFromDB()

        } catch (exception: java.lang.Exception) {
            Log.d("MyTAG", exception.message.toString())
        }
        if(movieList.size>0)
        {
            return movieList
        }
        else{
            movieList=getMoviesFromApi()
            movieLocalDataSource.saveMovieToDB(movieList)
        }
        return movieList
    }
}