package com.example.tmdbclient.data.repository.artist.datasource

import com.example.tmdbclient.data.model.aritist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache(): List<Artist>

    suspend fun saveArtistToCache(artist: List<Artist>)

}