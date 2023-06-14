package com.example.tmdbclient.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.usecase.GetTvShowUsecase
import com.example.tmdbclient.domain.usecase.UpdateTvShowUsecase

class TvShowViewModelFactory(
    private val getTvShowUsecase: GetTvShowUsecase,
    private val updateTvShowUsecase: UpdateTvShowUsecase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUsecase,updateTvShowUsecase) as T
    }
}