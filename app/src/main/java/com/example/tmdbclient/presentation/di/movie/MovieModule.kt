package com.example.tmdbclient.presentation.di.movie

import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import com.example.tmdbclient.domain.usecase.GetArtistUsecase
import com.example.tmdbclient.domain.usecase.GetMoviesUseCase
import com.example.tmdbclient.domain.usecase.UpdateArtistUsecase
import com.example.tmdbclient.domain.usecase.UpdateMoviesUsecase
import com.example.tmdbclient.presentation.artists.ArtistViewModelFactory
import com.example.tmdbclient.presentation.movies.MovieViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUsecase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }

}