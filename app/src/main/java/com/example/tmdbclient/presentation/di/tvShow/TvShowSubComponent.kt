package com.example.tmdbclient.presentation.di.tvShow

import com.example.tmdbclient.presentation.artists.ArtistActivity
import com.example.tmdbclient.presentation.tvshows.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }
}