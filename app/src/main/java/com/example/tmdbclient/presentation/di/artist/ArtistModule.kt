package com.example.tmdbclient.presentation.di.artist

import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import com.example.tmdbclient.domain.usecase.GetArtistUsecase
import com.example.tmdbclient.domain.usecase.UpdateArtistUsecase
import com.example.tmdbclient.presentation.artists.ArtistViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUsecase,
        updateArtistUseCase: UpdateArtistUsecase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistUseCase, updateArtistUseCase)
    }

}