package com.example.tmdbclient.data.repository.tvShow.datasource

import com.example.tmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
suspend fun getTvShowFromCache():List<TvShow>
suspend fun saveTvShowFromCache(movies:List<TvShow>)
}