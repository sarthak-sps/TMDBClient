package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.domain.repository.ArtistRepository
import com.example.tmdbclient.domain.repository.MovieRepository
import com.example.tmdbclient.domain.repository.TvShowRepository
import com.example.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class UseCaseModule {


    @Provides
    fun provideMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }


    @Provides
    fun provideUpdateMovieUsecase(movieRepository: MovieRepository): UpdateMoviesUsecase {
        return UpdateMoviesUsecase(movieRepository)
    }

    @Provides
    fun provideArtistUseCase(artistRepository: ArtistRepository): GetArtistUsecase {
        return GetArtistUsecase(artistRepository)
    }


    @Provides

    fun provideUpdateArtistUsecase(artistRepository: ArtistRepository): UpdateArtistUsecase {
        return UpdateArtistUsecase(artistRepository)
    }

    @Provides
    fun provideTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowUsecase {
        return GetTvShowUsecase(tvShowRepository)
    }


    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowUsecase {
        return UpdateTvShowUsecase(tvShowRepository)
    }
}