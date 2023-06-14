package com.example.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdbclient.data.model.aritist.Artist
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.tvshow.TvShow

@Database(
    entities = [TvShow::class, Artist::class, Movie::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowsDao
    abstract fun artistDao(): ArtistDao

}