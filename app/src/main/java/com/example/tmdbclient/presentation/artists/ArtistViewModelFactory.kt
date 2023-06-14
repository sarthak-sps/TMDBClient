package com.example.tmdbclient.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.usecase.GetArtistUsecase
import com.example.tmdbclient.domain.usecase.UpdateArtistUsecase

class ArtistViewModelFactory(
    private val getArtistUseCase: GetArtistUsecase,
    private val updateArtistUseCase: UpdateArtistUsecase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistUseCase,updateArtistUseCase) as T
    }
}