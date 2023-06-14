package com.example.tmdbclient.data.repository.artist.datasourceImpl

import com.example.tmdbclient.data.model.aritist.Artist
import com.example.tmdbclient.data.model.aritist.ArtistList
import com.example.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistToCache(artist: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artist)
    }

}