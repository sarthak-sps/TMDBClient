package com.example.tmdbclient.presentation.di.movie

import com.example.tmdbclient.presentation.artists.ArtistActivity
import com.example.tmdbclient.presentation.movies.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }
}