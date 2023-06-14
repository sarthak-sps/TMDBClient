package com.example.tmdbclient.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.usecase.GetArtistUsecase
import com.example.tmdbclient.domain.usecase.UpdateArtistUsecase
import com.example.tmdbclient.domain.usecase.UpdateMoviesUsecase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUsecase,
    private val updateArtistUseCase: UpdateArtistUsecase
) : ViewModel() {
    fun getArtistList()= liveData {
        val artistList= getArtistUseCase.execute()
        emit(artistList)
    }
    fun updateArtistList()= liveData {
        val artistList= updateArtistUseCase.execute()
        emit(artistList)
    }
}