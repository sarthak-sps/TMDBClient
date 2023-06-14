package com.example.tmdbclient.data.repository.tvShow.datasourceImpl

import com.example.tmdbclient.data.db.MovieDao
import com.example.tmdbclient.data.db.TvShowsDao
import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.data.repository.tvShow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowsDao) : TvShowLocalDataSource {
    override suspend fun getMoviesFromDB(): List<TvShow> {
        return tvShowDao.getShows()
    }

    override suspend fun saveMovieToDB(tvShow: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShow)
        }
    }


    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllShows()
        }
    }
}