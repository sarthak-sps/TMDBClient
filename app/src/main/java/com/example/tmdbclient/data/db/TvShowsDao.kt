package com.example.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclient.data.model.tvshow.TvShow

@Dao
interface TvShowsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShow:List<TvShow>)

    @Query("DELETE FROM popular_tvShows")
    suspend fun deleteAllShows()

    @Query("SELECT * FROM popular_tvShows")
    suspend fun getShows(): List<TvShow>
}