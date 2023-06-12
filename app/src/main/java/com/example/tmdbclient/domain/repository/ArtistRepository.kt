package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.model.aritist.Artist

interface ArtistRepository {
    suspend fun getArtist():List<Artist>
    suspend fun  updateArtist():List<Artist>
}