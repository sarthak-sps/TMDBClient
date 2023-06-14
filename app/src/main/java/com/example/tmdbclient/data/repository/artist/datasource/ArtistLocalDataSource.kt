package com.example.tmdbclient.data.repository.artist.datasource

import com.example.tmdbclient.data.model.aritist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistFromDB(): List<Artist>

    suspend fun saveArtistToDB(artist: List<Artist>)

    suspend fun clearAll()
}