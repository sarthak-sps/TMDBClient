package com.example.tmdbclient.data.repository.artist.datasource

import com.example.tmdbclient.data.model.aritist.ArtistList

interface ArtistRemoteDataSource {
    suspend fun getArtist(): retrofit2.Response<ArtistList>
}