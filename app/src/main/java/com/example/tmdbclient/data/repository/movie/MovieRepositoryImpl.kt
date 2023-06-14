package com.example.tmdbclient.data.repository.movie

import android.util.Log
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.domain.repository.MovieRepository

// implementation of movieRepo interface
class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    // overriding the methods of movie repo interface
    override suspend fun getMovies(): List<Movie>? {
        // returning the list of movie from cache
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newMovieList = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMovieToDB(newMovieList)
        movieCacheDataSource.saveMoviesFromCache(newMovieList)
        return newMovieList
    }

    suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var tvShowList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }
        } catch (exception: java.lang.Exception) {
            Log.d("MyTAG", exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var tvShowList: List<Movie>
        try {
            tvShowList = movieLocalDataSource.getMoviesFromDB()

        } catch (exception: java.lang.Exception) {
            Log.d("MyTAG", exception.message.toString())
        }
        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getMoviesFromApi()
            movieLocalDataSource.saveMovieToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var tvShowList: List<Movie>
        try {
            tvShowList = movieCacheDataSource.getMoviesFromCache()

        } catch (exception: java.lang.Exception) {
            Log.d("MyTAG", exception.message.toString())
        }
        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesFromCache(tvShowList)
        }
        return tvShowList
    }
}