package com.example.tmdbclient.data.repository.artist.datasourceImpl

import com.example.tmdbclient.data.db.ArtistDao
import com.example.tmdbclient.data.model.aritist.Artist
import com.example.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao) : ArtistLocalDataSource {
    override suspend fun getArtistFromDB(): List<Artist> {
        return artistDao.getArtist()
    }

    override suspend fun saveArtistToDB(artist: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtist(artist)
        }

    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtist()
        }

    }
}