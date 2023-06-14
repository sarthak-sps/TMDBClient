package com.example.tmdbclient.data.repository.artist.datasourceImpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.aritist.ArtistList
import com.example.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtist(): Response<ArtistList> {
        return tmdbService.getPopularArtist(apiKey)
    }
}