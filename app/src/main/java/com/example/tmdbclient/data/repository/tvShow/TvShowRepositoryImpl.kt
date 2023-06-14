package com.example.tmdbclient.data.repository.tvShow

import android.util.Log
import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.data.repository.tvShow.datasource.TvShowCacheDataSource
import com.example.tmdbclient.data.repository.tvShow.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.repository.tvShow.datasource.TvShowRemoteDataSource
import com.example.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {

    override suspend fun getTvShow(): List<TvShow>? {
        return getTvShowFromCache()
    }

    override suspend fun updateTvShow(): List<TvShow>? {
        val newTvShowList= getTvShowFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveMovieToDB(newTvShowList)
        tvShowCacheDataSource.saveTvShowFromCache(newTvShowList)
        return newTvShowList
    }



    suspend fun getTvShowFromApi(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowList = body.results
            }
        } catch (exception: java.lang.Exception) {
            Log.d("MyTAG", exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowFromDB(): List<TvShow> {
        lateinit var tvSHowList: List<TvShow>
        try {
            tvSHowList = tvShowLocalDataSource.getMoviesFromDB()

        } catch (exception: java.lang.Exception) {
            Log.d("MyTAG", exception.message.toString())
        }
        if (tvSHowList.size > 0) {
            return tvSHowList
        } else {
            tvSHowList = getTvShowFromApi()
            tvShowLocalDataSource.saveMovieToDB(tvSHowList)
        }
        return tvSHowList
    }
   suspend fun getTvShowFromCache():List<TvShow>{
       lateinit var tvShowList: List<TvShow>
       try {
           tvShowList = tvShowCacheDataSource.getTvShowFromCache()

       } catch (exception: java.lang.Exception) {
           Log.d("MyTAG", exception.message.toString())
       }
       if (tvShowList.size > 0) {
           return tvShowList
       } else {
           tvShowList = getTvShowFromDB()
           tvShowCacheDataSource.saveTvShowFromCache(tvShowList)
       }
       return tvShowList
   }


}