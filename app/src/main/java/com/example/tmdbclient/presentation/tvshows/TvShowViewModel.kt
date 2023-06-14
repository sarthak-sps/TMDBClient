package com.example.tmdbclient.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.usecase.GetTvShowUsecase
import com.example.tmdbclient.domain.usecase.UpdateTvShowUsecase

class TvShowViewModel(
    private val getTvShowUsecase: GetTvShowUsecase,
    private val updateTvShowUsecase: UpdateTvShowUsecase
) : ViewModel() {
    fun getTvShowList()= liveData {
        val tvShowList= getTvShowUsecase.execute()
        emit(tvShowList)
    }
    fun updateTvShowList()= liveData {
        val tvShowList = updateTvShowUsecase.execute()
        emit(tvShowList)
    }
}