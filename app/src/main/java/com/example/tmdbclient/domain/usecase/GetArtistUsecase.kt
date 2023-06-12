package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.model.aritist.Artist
import com.example.tmdbclient.domain.repository.ArtistRepository

class GetArtistUsecase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>?=artistRepository.getArtist()
}