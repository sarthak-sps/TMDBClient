package com.example.tmdbclient.presentation.di.tvShow

import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import com.example.tmdbclient.domain.usecase.GetArtistUsecase
import com.example.tmdbclient.domain.usecase.GetTvShowUsecase
import com.example.tmdbclient.domain.usecase.UpdateArtistUsecase
import com.example.tmdbclient.domain.usecase.UpdateTvShowUsecase
import com.example.tmdbclient.presentation.artists.ArtistViewModelFactory
import com.example.tmdbclient.presentation.tvshows.TvShowViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowUsecase: GetTvShowUsecase,
        updateTvShowUsecase: UpdateTvShowUsecase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowUsecase, updateTvShowUsecase)
    }

}