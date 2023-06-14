package com.example.tmdbclient.data.repository.artist

import android.util.Log
import com.example.tmdbclient.data.model.aritist.Artist
import com.example.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtist(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist> {
        val newArtistList = getArtistFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDB(newArtistList)
        artistCacheDataSource.saveArtistToCache(newArtistList)
        return newArtistList
    }


    suspend fun getArtistFromApi(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtist()
            val body = response.body()
            if (body != null) {
                artistList = body.results
            }
        } catch (exception: java.lang.Exception) {
            Log.d("MyTAG", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistFromDB()

        } catch (exception: java.lang.Exception) {
            Log.d("MyTAG", exception.message.toString())
        }
        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistFromApi()
            artistLocalDataSource.saveArtistToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistFromCache()

        } catch (exception: java.lang.Exception) {
            Log.d("MyTAG", exception.message.toString())
        }
        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistToCache(artistList)
        }
        return artistList
    }
}